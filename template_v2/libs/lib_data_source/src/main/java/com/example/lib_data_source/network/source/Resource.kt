package com.example.lib_data_source.network.source

sealed class Resource<out T> {
    data class Success<T>(val data: T) : Resource<T>()
    object EmptySuccess : Resource<Nothing>()
    data class Failed(val error: Error) : Resource<Nothing>()
    object Loading : Resource<Nothing>()

    fun <O> transform(block: (T) -> O): Resource<O> {
        return when (this) {
            is Success -> Success(block(this.data))
            is EmptySuccess -> EmptySuccess
            is Failed -> Failed(this.error)
            is Loading -> Loading
        }
    }
}