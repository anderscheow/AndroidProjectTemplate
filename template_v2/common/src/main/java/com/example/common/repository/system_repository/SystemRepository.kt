package com.example.common.repository.system_repository

import com.example.common.repository.BaseRepository
import com.example.common.repository.system_repository.local.SystemLocalDataSource
import com.example.common.repository.system_repository.remote.SystemRemoteDataSource
import com.example.lib_data_source.constant.SystemType
import com.example.lib_data_source.network.source.Resource
import com.example.lib_data_source.room.entities.system.SystemModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SystemRepository @Inject constructor(
    private val systemRemoteDataSource: SystemRemoteDataSource,
    private val systemLocalDataSource: SystemLocalDataSource
) : BaseRepository(), ISystemRepository {

    override suspend fun getBootstrappersInfo() {
        val result = systemRemoteDataSource.getBootstrappersInfo()
        if (result is Resource.Success) {
            systemLocalDataSource.saveBootstrappersInfo(result.data)
        }
    }

    override suspend fun getSystemModelFromLocal(type: SystemType): SystemModel? =
        systemLocalDataSource.getSystemModel(type)

    override fun getSystemModelFromLocalAsFlow(type: SystemType): Flow<SystemModel?> =
        systemLocalDataSource.getSystemModelAsFlow(type)

    override suspend fun saveSystemModelToLocal(systemModel: SystemModel) =
        systemLocalDataSource.saveSystemModel(systemModel)

    override fun clearPreferencesAndDatabase() =
        systemLocalDataSource.clearPreferencesAndDatabase()
}