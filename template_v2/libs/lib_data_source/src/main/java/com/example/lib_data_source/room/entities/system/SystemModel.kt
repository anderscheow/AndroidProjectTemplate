package com.example.lib_data_source.room.entities.system

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.lib_data_source.constant.SystemType
import com.example.lib_data_source.util.MoshiUtil

@Entity(tableName = "System")
data class SystemModel(
    @PrimaryKey
    val type: SystemType,
    val value: String?
) {

    companion object {
        fun <T> fromObject(type: SystemType, clazz: Class<T>, value: T): SystemModel {
            return SystemModel(
                type,
                MoshiUtil.getJsonAdapter(clazz).toJson(value)
            )
        }

        fun <T> fromList(type: SystemType, clazz: Class<T>, value: List<T>): SystemModel {
            return SystemModel(
                type,
                MoshiUtil.getListJsonAdapter(clazz).toJson(value)
            )
        }
    }

    fun <T> asObject(clazz: Class<T>): T? {
        return if (value == null) {
            null
        } else {
            MoshiUtil.getJsonAdapter(clazz).fromJson(value)
        }
    }

    fun <T> asList(clazz: Class<T>): List<T>? {
        return if (value == null) {
            null
        } else {
            MoshiUtil.getListJsonAdapter(clazz).fromJson(value)
        }
    }
}
