package com.example.lib_data_source.room.converters

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.lib_data_source.constant.SystemType

@TypeConverters
object EnumConverters {

    //region [SystemType]
    @TypeConverter
    fun toSystemType(value: String): SystemType {
        return SystemType.valueOf(value)
    }

    @TypeConverter
    fun fromSystemType(value: SystemType): String {
        return value.name
    }
    //endregion
}