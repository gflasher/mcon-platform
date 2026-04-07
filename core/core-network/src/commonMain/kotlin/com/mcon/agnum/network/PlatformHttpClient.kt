package com.mcon.agnum.network

import io.ktor.client.HttpClient

expect fun createPlatformHttpClient(): HttpClient
