package br.edu.unisep.exemplofb.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import br.edu.unisep.exemplofb.databinding.ActivityLoginBinding
import br.edu.unisep.exemplofb.domain.dto.LoginDto
import br.edu.unisep.exemplofb.ui.home.HomeActivity
import br.edu.unisep.exemplofb.ui.login.viewmodel.LoginViewModel
import br.edu.unisep.exemplofb.ui.register.RegisterActivity
import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.AuthResult

class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        checkUserSaved()
        binding.btnNotRegistered.setOnClickListener {
            startActivity(RegisterActivity.newIntent(this))
        }

        binding.btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val username = binding.etLogin.text.toString()
        val password = binding.etPassword.text.toString()

        executeAuth(username, password)
    }

    private fun executeAuth(username: String, password: String) {
        viewModel.login(LoginDto(
            username,
            password))
        viewModel.onLoginComplete.observe(this,{message(it)})
    }

    private fun message(task: Task<AuthResult>) {
        task.addOnSuccessListener(::onLoginSuccess)
            .addOnFailureListener { error ->
                error.printStackTrace()
                Snackbar.make(binding.root, "Dados inválidos para o login!", Snackbar.LENGTH_LONG)
                    .show()
            }

    }

    private fun onLoginSuccess(result: AuthResult) {
        if (binding.swRememberUser.isChecked) {
            val prefs = getSharedPreferences("example-firebase-prefs", MODE_PRIVATE)
            prefs.edit {
                putString("user-id", result.user?.uid)
                putString("user-email", result.user?.email)
                putString("user-password", binding.etPassword.text.toString())
            }
        }

        startActivity(HomeActivity.newIntent(this))
        finish()
    }

    private fun checkUserSaved() {
        val prefs = getSharedPreferences("example-firebase-prefs", MODE_PRIVATE)
        if (prefs.contains("user-id")) {
            val username = prefs.getString("user-email", "") ?: ""
            val password = prefs.getString("user-password", "") ?: ""

            executeAuth(username, password)
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }

}