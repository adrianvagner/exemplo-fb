package br.edu.unisep.exemplofb.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import br.edu.unisep.exemplofb.R
import br.edu.unisep.exemplofb.domain.dto.LoginDto
import br.edu.unisep.exemplofb.ui.home.HomeActivity
import br.edu.unisep.exemplofb.ui.login.LoginActivity
import br.edu.unisep.exemplofb.ui.login.viewmodel.LoginViewModel
import br.edu.unisep.exemplofb.ui.splash.viewmodel.SplashViewModel
import com.google.firebase.auth.AuthResult

class SplashActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        Handler().postDelayed(Runnable {
            setTheme(R.style.Theme_ExemploFirebase)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 3000)

    }




}