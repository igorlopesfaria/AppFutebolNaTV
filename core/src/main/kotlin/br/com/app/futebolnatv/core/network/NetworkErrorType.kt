package br.com.app.futebolnatv.core.network

import br.com.app.futebolnatv.core.exceptions.data.NetworkException
import br.com.app.futebolnatv.core.exceptions.data.ServerException
import br.com.app.futebolnatv.core.exceptions.data.UnauthorizedException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.HttpURLConnection
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

fun Throwable.toRequestThrowable(): Throwable {
    return when (this) {
        is UnknownHostException,
        is TimeoutException,
        is InterruptedException,
        is SocketTimeoutException,
        is SocketException,
        is ConnectException -> NetworkException()
        is HttpException -> parseHttpError()
        else -> this
    }
}

internal fun HttpException.parseHttpError(): Exception {
    return when (code()) {
        HttpURLConnection.HTTP_UNAUTHORIZED -> UnauthorizedException()
        else -> ServerException()
    }
}

fun Throwable.getApiErrorType(): ApiErrorType =
    when (this) {
        is UnauthorizedException -> ApiErrorType.Unauthorized
        is NetworkException -> ApiErrorType.Network
        else -> ApiErrorType.ServerError
    }