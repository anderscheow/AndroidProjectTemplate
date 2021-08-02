package com.example.common.repository.auth_repository.local

import com.example.lib_data_source.model.AuthModel
import com.example.lib_data_source.preference.IAppSharedPreference
import com.example.lib_data_source.preference.SPKey
import javax.inject.Inject

class AuthLocalDataSource @Inject constructor(
    private val sharedPreference: IAppSharedPreference
) {

    fun getAuthModel(): AuthModel? =
        sharedPreference.getObject(AuthModel::class.java, SPKey.KEY_AUTH_MODEL)

    fun saveAuthModel(authModel: AuthModel) {
        sharedPreference.getObject(AuthModel::class.java, SPKey.KEY_AUTH_MODEL, authModel)
    }

    fun clearAuthModel() {
        sharedPreference.clear(AuthModel::class.java, SPKey.KEY_AUTH_MODEL)
    }
}