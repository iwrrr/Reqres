package com.iwrrr.reqres

import android.app.Application
import com.iwrrr.reqres.data.User
import com.iwrrr.reqres.di.MainModule
import com.iwrrr.reqres.event.StateEvent
import kotlinx.coroutines.flow.Flow
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(MainModule().module)
        }
    }
}