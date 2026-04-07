package com.mcon.agnum.database

import android.content.Context
import app.cash.sqldelight.android.AndroidSqliteDriver
import app.cash.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = MconDatabase.Schema,
            context = context,
            name = DATABASE_NAME,
        )
    }
}
