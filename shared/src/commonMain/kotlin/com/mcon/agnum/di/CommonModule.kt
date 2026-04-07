package com.mcon.agnum.di

import com.mcon.agnum.network.HttpClientFactory
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClientFactory.create(enableLogging = true)
    }
}

val commonModule = module {
    includes(networkModule)
}

expect val platformModule: Module
