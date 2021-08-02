package com.example.lib_data_source.preference

interface IAppSharedPreference {

    fun getString(key: SPKey, defaultValue: String? = null): String?

    fun saveString(key: SPKey, value: String?)

    fun getBoolean(key: SPKey, defaultValue: Boolean? = null): Boolean

    fun saveBoolean(key: SPKey, value: Boolean)

    fun getInt(key: SPKey, defaultValue: Int? = null): Int

    fun saveInt(key: SPKey, value: Int)

    fun getLong(key: SPKey, defaultValue: Long? = null): Long

    fun saveLong(key: SPKey, value: Long)

    fun getFloat(key: SPKey, defaultValue: Float? = null): Float

    fun saveFloat(key: SPKey, value: Float)

    fun <T> getObject(clazz: Class<T>, key: SPKey, defaultValue: T? = null): T?

    fun <T> saveObject(clazz: Class<T>, key: SPKey, value: T?)

    fun <T> getList(clazz: Class<T>, key: SPKey, defaultValue: List<T>? = null): List<T>?

    fun <T> saveList(clazz: Class<T>, key: SPKey, value: List<T>)

    fun <T> clear(clazz: Class<T>, key: SPKey)

    fun clearAfterLogout()
}