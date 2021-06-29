package br.edu.unisep.exemplofb.ui.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.exemplofb.domain.dto.LoginDto
import br.edu.unisep.exemplofb.domain.repository.LoginRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {

    val onLoginComplete = MutableLiveData<Task<AuthResult>>()


    fun login(loginDto: LoginDto) {
        viewModelScope.launch {
            onLoginComplete.postValue(repository.login(loginDto))
        }
    }

}