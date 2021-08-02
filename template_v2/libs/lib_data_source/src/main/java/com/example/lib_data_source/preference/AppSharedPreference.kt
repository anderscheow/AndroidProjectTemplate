package com.example.lib_data_source.preference

import android.content.Context
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.lib_data_source.model.AuthModel
import com.example.lib_data_source.model.UserInfoModel
import com.example.lib_data_source.util.MoshiUtil

enum class SPKey {
    KEY_SYSTEM_CONFIG_MODEL,
    KEY_AUTH_MODEL
}

class AppSharedPreference(context: Context) : IAppSharedPreference {

    companion object {
        private const val KEY_SHARED_PREFERENCE_NAME = "Yippi"

        private const val DEFAULT_BOOLEAN: Boolean = false
        private const val DEFAULT_INT: Int = -1
        private const val DEFAULT_LONG: Long = -1L
        private const val DEFAULT_FLOAT: Float = -1f
    }

    private val mMasterKeyAlias = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val mSharedPreference by lazy {
        EncryptedSharedPreferences.create(
            context,
            KEY_SHARED_PREFERENCE_NAME,
            mMasterKeyAlias,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    override fun getString(key: SPKey, defaultValue: String?): String? {
        return mSharedPreference.getString(key.name, defaultValue)
    }

    override fun saveString(key: SPKey, value: String?) {
        mSharedPreference.edit {
            this.putString(key.name, value)
        }
    }

    override fun getBoolean(key: SPKey, defaultValue: Boolean?): Boolean {
        return mSharedPreference.getBoolean(key.name, defaultValue ?: DEFAULT_BOOLEAN)
    }

    override fun saveBoolean(key: SPKey, value: Boolean) {
        mSharedPreference.edit {
            this.putBoolean(key.name, value)
        }
    }

    override fun getInt(key: SPKey, defaultValue: Int?): Int {
        return mSharedPreference.getInt(key.name, defaultValue ?: DEFAULT_INT)
    }

    override fun saveInt(key: SPKey, value: Int) {
        mSharedPreference.edit {
            this.putInt(key.name, value)
        }
    }

    override fun getLong(key: SPKey, defaultValue: Long?): Long {
        return mSharedPreference.getLong(key.name, defaultValue ?: DEFAULT_LONG)
    }

    override fun saveLong(key: SPKey, value: Long) {
        mSharedPreference.edit {
            this.putLong(key.name, value)
        }
    }

    override fun getFloat(key: SPKey, defaultValue: Float?): Float {
        return mSharedPreference.getFloat(key.name, defaultValue ?: DEFAULT_FLOAT)
    }

    override fun saveFloat(key: SPKey, value: Float) {
        mSharedPreference.edit {
            this.putFloat(key.name, value)
        }
    }

    override fun <T> getObject(clazz: Class<T>, key: SPKey, defaultValue: T?): T? {
        return mSharedPreference.getString(key.name, null)?.run {
            MoshiUtil.getJsonAdapter(clazz).fromJson(this)
        }
    }

    override fun <T> saveObject(clazz: Class<T>, key: SPKey, value: T?) {
        mSharedPreference.edit {
            val json = MoshiUtil.getJsonAdapter(clazz).toJson(value)
            this.putString(key.name, json)
        }
    }

    override fun <T> getList(clazz: Class<T>, key: SPKey, defaultValue: List<T>?): List<T>? {
        return mSharedPreference.getString(key.name, null)?.run {
            MoshiUtil.getListJsonAdapter(clazz).fromJson(this)
        }
    }

    override fun <T> saveList(clazz: Class<T>, key: SPKey, value: List<T>) {
        mSharedPreference.edit {
            this.putString(
                key.name,
                MoshiUtil.getListJsonAdapter(clazz).toJson(value)
            )
        }
    }

    override fun <T> clear(clazz: Class<T>, key: SPKey) {
        mSharedPreference.edit {
            when (clazz) {
                String::class -> this.putString(key.name, null)
                Boolean::class -> this.putBoolean(key.name, DEFAULT_BOOLEAN)
                Int::class -> this.putInt(key.name, DEFAULT_INT)
                Long::class -> this.putLong(key.name, DEFAULT_LONG)
                Float::class -> this.putFloat(key.name, DEFAULT_FLOAT)
                else -> {
                    this.putString(key.name, null)
                }
            }
        }
    }

    override fun clearAfterLogout() {
        clear(AuthModel::class.java, SPKey.KEY_AUTH_MODEL)
    }
}