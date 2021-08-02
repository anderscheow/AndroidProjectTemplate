package com.example.lib_data_source.room.dao

import androidx.room.*

abstract class BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insertOne(model: T): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insertMany(models: List<T>): List<Long>

    @Update
    abstract suspend fun updateOne(model: T)

    @Update
    abstract suspend fun updateMany(models: List<T>)

    @Delete
    abstract suspend fun deleteOne(model: T)

    @Delete
    abstract suspend fun deleteMany(models: List<T>)

    @Transaction
    open suspend fun upsertOne(model: T) {
        val id: Long = insertOne(model)
        if (id == -1L) {
            updateOne(model)
        }
    }

    @Transaction
    open suspend fun upsertMany(models: List<T>) {
        val insertResult = insertMany(models)
        val updateList = arrayListOf<T>()

        insertResult.forEachIndexed { index, result ->
            if (result == -1L) {
                updateList.add(models[index])
            }
        }

        if (updateList.isNotEmpty()) {
            updateMany(updateList)
        }
    }
}