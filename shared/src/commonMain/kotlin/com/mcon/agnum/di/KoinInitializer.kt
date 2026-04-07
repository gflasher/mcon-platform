package com.mcon.agnum.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initKoin(additionalModules: List<Module> = emptyList()): KoinApplication {
    return startKoin {
        modules(commonModule, platformModule)
        modules(additionalModules)
    }
}
