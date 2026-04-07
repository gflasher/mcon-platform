package com.mcon.agnum.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.utils.io.errors.IOException

abstract class ApiService(protected val client: HttpClient, protected val baseUrl: String) {

    protected suspend inline fun <reified T> safeGet(endpoint: String): ApiResult<T> {
        return try {
            val response = client.get {
                url("$baseUrl$endpoint")
            }
            ApiResult.Success(response.body<T>())
        } catch (e: io.ktor.client.plugins.ClientRequestException) {
            ApiResult.Failure(NetworkError.HttpError(e.response.status.value, e.message ?: "HTTP 오류"))
        } catch (e: IOException) {
            ApiResult.Failure(NetworkError.ConnectionError(e))
        } catch (e: Exception) {
            ApiResult.Failure(NetworkError.UnknownError)
        }
    }

    protected suspend inline fun <reified T, reified R> safePost(endpoint: String, body: T): ApiResult<R> {
        return try {
            val response = client.post {
                url("$baseUrl$endpoint")
                contentType(ContentType.Application.Json)
                setBody(body)
            }
            ApiResult.Success(response.body<R>())
        } catch (e: io.ktor.client.plugins.ClientRequestException) {
            ApiResult.Failure(NetworkError.HttpError(e.response.status.value, e.message ?: "HTTP 오류"))
        } catch (e: IOException) {
            ApiResult.Failure(NetworkError.ConnectionError(e))
        } catch (e: Exception) {
            ApiResult.Failure(NetworkError.UnknownError)
        }
    }
}
