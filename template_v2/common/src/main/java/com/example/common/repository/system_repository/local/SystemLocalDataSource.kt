package com.example.common.repository.system_repository.local

import com.example.lib_data_source.constant.SystemType
import com.example.lib_data_source.model.SystemConfigModel
import com.example.lib_data_source.preference.IAppSharedPreference
import com.example.lib_data_source.preference.SPKey
import com.example.lib_data_source.room.AppDatabase
import com.example.lib_data_source.room.entities.system.SystemModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SystemLocalDataSource @Inject constructor(
    private val appDatabase: AppDatabase,
    private val sharedPreference: IAppSharedPreference
) {

    suspend fun getSystemModel(type: SystemType): SystemModel? =
        appDatabase.getSystemDao().getByType(type)

    fun getSystemModelAsFlow(type: SystemType): Flow<SystemModel?> =
        appDatabase.getSystemDao().getByTypeAsFlow(type)

    suspend fun saveSystemModel(systemModel: SystemModel) {
        appDatabase.getSystemDao().upsertOne(systemModel)
    }

    fun saveBootstrappersInfo(systemConfigModel: SystemConfigModel) =
        sharedPreference.saveObject(
            SystemConfigModel::class.java,
            SPKey.KEY_SYSTEM_CONFIG_MODEL,
            systemConfigModel
        )

    fun getBootstrappersInfo(): SystemConfigModel? =
        sharedPreference.getObject(SystemConfigModel::class.java, SPKey.KEY_SYSTEM_CONFIG_MODEL)

    fun clearPreferencesAndDatabase() {
        appDatabase.clearAllTables()
        sharedPreference.clearAfterLogout()
    }
}