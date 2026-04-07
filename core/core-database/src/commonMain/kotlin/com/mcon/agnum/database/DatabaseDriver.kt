package com.mcon.agnum.database

import app.cash.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

const val DATABASE_NAME = "mcon_agnum.db"
