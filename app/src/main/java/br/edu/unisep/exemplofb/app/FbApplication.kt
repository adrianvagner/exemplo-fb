package br.edu.unisep.exemplofb.app

import android.app.Application
import br.edu.unisep.exemplofb.di.repositoryModule
import br.edu.unisep.exemplofb.di.viewModelModule
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FbApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(applicationContext)

            modules(
                repositoryModule,
                viewModelModule,
            )
        }
    }
}