package com.easipos.template.api.misc

import com.easipos.template.models.Result
import com.easipos.template.util.ApiErrorException
import com.easipos.template.util.ErrorUtil
import com.google.gson.Gson
import retrofit2.HttpException
import java.net.ConnectException
import java.net.NoRouteToHostException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

fun <R, T> parseResponse(responseModel: ResponseModel<R>, transformer: (R) -> T): Result<T> {
    return if (responseModel.error.not()) {
        if (responseModel.data != null) {
            Result.Success(transformer(responseModel.data))
        } else {
            Result.Error(ErrorUtil.GENERIC_API_ERROR_EXCEPTION)
        }
    } else {
        Result.Error(ApiErrorException(responseModel.code, responseModel.message))
    }
}

fun parseResponse(responseModel: EmptyResponseModel): Result<Nothing> {
    return if (responseModel.error.not()) {
        Result.EmptySuccess
    } else {
        Result.Error(ApiErrorException(responseModel.code, responseModel.message))
    }
}

fun parseException(ex: Exception): Result<Nothing> {
    return when (ex) {
        is HttpException -> {
            try {
                if (ex.response() != null && ex.response()!!.errorBody() != null) {
                    val model = Gson().fromJson(ex.response()!!.errorBody()!!.string(), EmptyResponseModel::class.java)
                    Result.Error(ApiErrorException(model.code, model.message))
                } else {
                    Result.Error(ErrorUtil.GENERIC_API_ERROR_EXCEPTION)
                }
            } catch (ex: Exception) {
                Result.Error(ex)
            }
        }
        is ConnectException, is TimeoutException, is SocketTimeoutException, is UnknownHostException, is NoRouteToHostException -> {
            Result.Error(ErrorUtil.TIMEOUT_ERROR_EXCEPTION)
        }
        else -> {
            Result.Error(ex)
        }
    }
}