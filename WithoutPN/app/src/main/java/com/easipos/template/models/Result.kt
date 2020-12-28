package com.easipos.template.models

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    object EmptySuccess : Result<Nothing>()
    data class Error(val exception: Exception) : Result<Nothing>()
}