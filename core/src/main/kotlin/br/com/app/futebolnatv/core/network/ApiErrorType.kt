package br.com.app.futebolnatv.core.network

sealed class ApiErrorType : Exception() {
    object ServerError : ApiErrorType()
    object Network : ApiErrorType()
    object Unauthorized : ApiErrorType()
}