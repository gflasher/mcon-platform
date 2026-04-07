package com.mcon.agnum.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object HttpClientFactory {
    fun create(
        enableLogging: Boolean = false,
        connectTimeoutMillis: Long = 10_000L,
        requestTimeoutMillis: Long = 30_000L,
    ): HttpClient = createPlatformHttpClient().config {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    encodeDefaults = true
                }
            )
        }

        install(HttpTimeout) {
            this.connectTimeoutMillis = connectTimeoutMillis
            this.requestTimeoutMillis = requestTimeoutMillis
        }

        if (enableLogging) {
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println("[MconNetwork] $message")
                    }
                }
                level = LogLevel.BODY
            }
        }
    }
}
