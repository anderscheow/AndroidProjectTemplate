package com.example.lib_data_source.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.lib_data_source.constant.SystemType
import com.example.lib_data_source.room.entities.system.SystemModel
import kotlinx.coroutines.flow.Flow

@Dao
abstract class SystemDao : BaseDao<SystemModel>() {

    @Query("SELECT * FROM System WHERE type = :type")
    abstract suspend fun getByType(type: SystemType): SystemModel?

    @Query("SELECT * FROM System WHERE type = :type")
    abstract fun getByTypeAsFlow(type: SystemType): Flow<SystemModel?>
}