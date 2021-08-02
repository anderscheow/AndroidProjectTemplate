package com.example.lib_data_source.network.source

import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResponse(
        request: suspend () -> Response<T>
    ): Resource<T> {
        return try {
            val result = request.invoke()
            if (result.isSuccessful) {
                if (result.body() != null) {
                    Resource.Success(result.body()!!)
                } else {
                    Resource.EmptySuccess
                }
            } else {
                Resource.Failed(Error(0, result.errorBody()?.string() ?: ""))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failed(Error(0, e.localizedMessage))
        }
    }
}