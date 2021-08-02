package com.example.common.repository.auth_repository.remote

import com.example.lib_data_source.model.AuthModel
import com.example.lib_data_source.network.ApiConstant.APP_PATH_LOGIN
import com.example.lib_data_source.network.ApiConstant.APP_PATH_REFRESH_TOKEN
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST(APP_PATH_LOGIN)
    suspend fun login(
        @Field("username") userName: String,
        @Field("password") password: String,
    ): Response<AuthModel>

    @FormUrlEncoded
    @POST("/auth/login")
    suspend fun logout(
        @Field("username") userName: String,
        @Field("password") password: String,
    ): Response<AuthModel>

    @POST(APP_PATH_REFRESH_TOKEN)
    suspend fun refreshSession(): Response<AuthModel>
}