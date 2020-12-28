package com.easipos.template.api.services

import com.easipos.template.api.ApiEndpoint
import com.easipos.template.api.misc.EmptyResponseModel
import com.easipos.template.api.misc.ResponseModel
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST(ApiEndpoint.CHECK_VERSION)
    suspend fun checkVersion(@Body body: RequestBody): ResponseModel<Boolean>

    @POST(ApiEndpoint.REGISTER_REMOVE_JPUSH_REG_ID)
    suspend fun registerFcmToken(@Body body: RequestBody): EmptyResponseModel

    @POST(ApiEndpoint.REGISTER_REMOVE_JPUSH_REG_ID)
    suspend fun removeFcmToken(@Body body: RequestBody): EmptyResponseModel
}
