package com.mcon.agnum

import android.app.Application
import com.mcon.agnum.di.commonModule
import com.mcon.agnum.di.platformModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MconAgnumApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MconAgnumApplication)
            modules(commonModule, platformModule)
        }
    }
}
