package br.edu.unisep.exemplofb.di

import br.edu.unisep.exemplofb.domain.repository.LoginRepository
import br.edu.unisep.exemplofb.ui.login.viewmodel.LoginViewModel
import br.edu.unisep.exemplofb.ui.register.viewmodel.RegisterViewModel
import br.edu.unisep.exemplofb.ui.splash.viewmodel.SplashViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single { LoginRepository(Firebase.auth) }
}

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { SplashViewModel(get()) }
}