package com.example.common.repository.system_repository

import com.example.lib_data_source.constant.SystemType
import com.example.lib_data_source.room.entities.system.SystemModel
import kotlinx.coroutines.flow.Flow

interface ISystemRepository {

    suspend fun getBootstrappersInfo()

    suspend fun getSystemModelFromLocal(type: SystemType): SystemModel?

    fun getSystemModelFromLocalAsFlow(type: SystemType): Flow<SystemModel?>

    suspend fun saveSystemModelToLocal(systemModel: SystemModel)

    fun clearPreferencesAndDatabase()
}