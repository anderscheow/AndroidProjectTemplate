package com.example.common.repository.auth_repository

import com.example.common.repository.BaseRepository
import com.example.common.repository.auth_repository.local.AuthLocalDataSource
import com.example.common.repository.auth_repository.remote.AuthRemoteDataSource
import com.example.lib_data_source.model.AuthModel
import com.example.lib_data_source.network.source.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
) : BaseRepository(), IAuthRepository {

    override fun login(): Flow<Resource<AuthModel>> {
        return flow {
            val result = authRemoteDataSource.login()
            if (result is Resource.Success) {
                saveAuthModel(result.data)
            }
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun logout(): Flow<Resource<AuthModel>> {
        return flow {
            val result = authRemoteDataSource.logout()
            clearAuthModel()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun refreshSession() {
        val result = authRemoteDataSource.refreshSession()
        if (result is Resource.Success) {
            saveAuthModel(result.data)
        }
    }

    override fun isGuest(): Boolean = authLocalDataSource.getAuthModel() == null

    override fun isLoggedIn(): Boolean = isGuest().not()

    private fun saveAuthModel(authModel: AuthModel) =
        authLocalDataSource.saveAuthModel(authModel)

    private fun clearAuthModel() = authLocalDataSource.clearAuthModel()
}