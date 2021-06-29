package br.edu.unisep.exemplofb.ui.splash.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.exemplofb.domain.dto.LoginDto
import br.edu.unisep.exemplofb.domain.repository.LoginRepository
import kotlinx.coroutines.launch

class SplashViewModel(private val repository: LoginRepository) : ViewModel() {


    val onLoginComplete = MutableLiveData<Unit>()
    var unity: Int = 0


    fun login(loginDto: LoginDto) {
        viewModelScope.launch {
            repository.login(loginDto)
            onLoginComplete.postValue(Unit)
        }
    }


}