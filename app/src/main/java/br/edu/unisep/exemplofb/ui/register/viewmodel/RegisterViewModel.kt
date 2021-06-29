package br.edu.unisep.exemplofb.ui.register.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.exemplofb.databinding.ActivityRegisterBinding
import br.edu.unisep.exemplofb.domain.dto.LoginDto
import br.edu.unisep.exemplofb.domain.dto.RegisterDto
import br.edu.unisep.exemplofb.domain.repository.LoginRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.launch

class RegisterViewModel(private val repository: LoginRepository) : ViewModel() {


    val onSaveComplete = MutableLiveData<Task<AuthResult>>()

    fun save(registerDto: RegisterDto){
        viewModelScope.launch {
            onSaveComplete.postValue(repository.register(registerDto))
        }

    }


}