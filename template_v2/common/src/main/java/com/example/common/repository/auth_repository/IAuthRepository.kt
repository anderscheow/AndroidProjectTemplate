package com.example.common.repository.auth_repository

import com.example.lib_data_source.model.AuthModel
import com.example.lib_data_source.network.source.Resource
import kotlinx.coroutines.flow.Flow

interface IAuthRepository {

    fun login(): Flow<Resource<AuthModel>>

    suspend fun logout(): Flow<Resource<AuthModel>>

    suspend fun refreshSession()

    fun isGuest(): Boolean

    fun isLoggedIn(): Boolean
}