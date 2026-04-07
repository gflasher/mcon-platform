package com.mcon.agnum.network

sealed class NetworkError : Exception() {
    data class HttpError(val code: Int, override val message: String) : NetworkError()
    data class ConnectionError(override val cause: Throwable?) : NetworkError()
    data class SerializationError(override val cause: Throwable?) : NetworkError()
    data object UnknownError : NetworkError()
}

sealed class ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Failure(val error: NetworkError) : ApiResult<Nothing>()
}

inline fun <T> ApiResult<T>.onSuccess(block: (T) -> Unit): ApiResult<T> {
    if (this is ApiResult.Success) block(data)
    return this
}

inline fun <T> ApiResult<T>.onFailure(block: (NetworkError) -> Unit): ApiResult<T> {
    if (this is ApiResult.Failure) block(error)
    return this
}
