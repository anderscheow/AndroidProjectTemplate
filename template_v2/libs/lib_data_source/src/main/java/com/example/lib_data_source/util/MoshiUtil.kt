package com.example.lib_data_source.util

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object MoshiUtil {

    private val factory by lazy { KotlinJsonAdapterFactory() }

    fun <T> getJsonAdapter(clazz: Class<T>): JsonAdapter<T> {
        val moshi = Moshi.Builder().add(factory).build()
        return moshi.adapter(clazz)
    }

    fun <T> getListJsonAdapter(clazz: Class<T>): JsonAdapter<List<T>> {
        val moshi = Moshi.Builder().add(factory).build()
        val type = Types.newParameterizedType(
            List::class.java,
            clazz
        )
        return moshi.adapter(type)
    }

    fun <K, V> getMapJsonAdapter(keyClazz: Class<K>, valueClazz: Class<V>): JsonAdapter<Map<K, V>> {
        val moshi = Moshi.Builder().add(factory).build()
        val type = Types.newParameterizedType(
            Map::class.java,
            keyClazz,
            valueClazz
        )
        return moshi.adapter(type)
    }
}