package com.easipos.template.api.services

import com.easipos.template.api.ApiEndpoint
import com.easipos.template.api.misc.ResponseModel
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST(ApiEndpoint.CHECK_VERSION)
    suspend fun checkVersion(@Body body: RequestBody): ResponseModel<Boolean>
}
