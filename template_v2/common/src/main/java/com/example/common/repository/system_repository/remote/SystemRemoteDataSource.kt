package com.example.common.repository.system_repository.remote

import com.example.lib_data_source.model.SystemConfigModel
import com.example.lib_data_source.network.source.BaseDataSource
import com.example.lib_data_source.network.source.Resource
import javax.inject.Inject

class SystemRemoteDataSource @Inject constructor(
    private val systemApi: SystemApi
) : BaseDataSource() {

    suspend fun getBootstrappersInfo(): Resource<SystemConfigModel> {
        return getResponse(
            request = { systemApi.getBootstrappersInfo() },
        )
    }
}