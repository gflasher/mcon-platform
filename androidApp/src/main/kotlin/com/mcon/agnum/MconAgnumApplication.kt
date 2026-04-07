package com.mcon.agnum

import android.app.Application
import com.mcon.agnum.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class MconAgnumApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@MconAgnumApplication)
        }
    }
}
