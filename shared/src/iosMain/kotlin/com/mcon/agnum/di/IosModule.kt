package com.mcon.agnum.di

import com.mcon.agnum.database.DatabaseDriverFactory
import com.mcon.agnum.database.MconDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single { DatabaseDriverFactory() }
    single { MconDatabase(get<DatabaseDriverFactory>().createDriver()) }
}
