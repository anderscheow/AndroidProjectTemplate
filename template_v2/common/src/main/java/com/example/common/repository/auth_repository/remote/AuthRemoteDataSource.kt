package com.example.common.repository.auth_repository.remote

import com.example.lib_data_source.model.AuthModel
import com.example.lib_data_source.network.source.BaseDataSource
import com.example.lib_data_source.network.source.Resource
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val authApi: AuthApi
) : BaseDataSource() {

    suspend fun login(): Resource<AuthModel> {
        return getResponse(
            request = { authApi.login("pipipapipu2", "123456") },
        )
    }

    suspend fun logout(): Resource<AuthModel> {
        return getResponse(
            request = { authApi.logout("", "") },
        )
    }

    suspend fun refreshSession(): Resource<AuthModel> {
        return getResponse(
            request = { authApi.refreshSession() },
        )
    }
}