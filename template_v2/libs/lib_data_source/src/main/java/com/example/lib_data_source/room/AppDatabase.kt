package com.example.lib_data_source.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.lib_data_source.room.converters.EnumConverters
import com.example.lib_data_source.room.converters.GeneralConverters
import com.example.lib_data_source.room.dao.SystemDao
import com.example.lib_data_source.room.entities.system.SystemModel

@Database(
    entities = [
        SystemModel::class
    ], version = 1,
    exportSchema = true
)
@TypeConverters(
    value = [
        GeneralConverters::class,
        EnumConverters::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getSystemDao(): SystemDao
}
