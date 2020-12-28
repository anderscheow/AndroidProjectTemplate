package com.easipos.template.util

class ApiErrorException(var code: Int, var errorMessage: String)
    : Exception() {

    fun toReadableString(): String {
        return errorMessage.trim()
    }

    override fun toString(): String {
        return "ApiErrorException(errorMessage=$errorMessage)"
    }
}

object ErrorUtil {

    private val GENERIC_ERROR_MESSAGE = "Something has gone wrong. Please try again."
    private val CONNECTION_TIMEOUT_ERROR_MESSAGE = "There's a problem with your Internet connection. Please try again."

    var GENERIC_API_ERROR_EXCEPTION = ApiErrorException(-1, GENERIC_ERROR_MESSAGE)
    var TIMEOUT_ERROR_EXCEPTION = ApiErrorException(-2, CONNECTION_TIMEOUT_ERROR_MESSAGE)

    fun parseException(error: Throwable): String {
        return when (error) {
            is ApiErrorException -> error.toReadableString()
            else -> error.localizedMessage ?: ""
        }
    }
}