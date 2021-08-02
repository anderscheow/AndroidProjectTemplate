package com.example.common.repository.system_repository.remote

import com.example.lib_data_source.model.SystemConfigModel
import com.example.lib_data_source.network.ApiConstant.APP_PATH_GET_BOOTSTRAPERS_INFO
import retrofit2.Response
import retrofit2.http.GET

interface SystemApi {

    @GET(APP_PATH_GET_BOOTSTRAPERS_INFO)
    suspend fun getBootstrappersInfo(): Response<SystemConfigModel>
}