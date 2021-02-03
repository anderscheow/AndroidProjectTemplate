package com.easipos.template.repositories.user

import com.easipos.template.api.requests.BasicRequestModel
import com.easipos.template.api.requests.user.UpdateProfileRequestModel
import com.easipos.template.datasource.DataFactory
import com.easipos.template.mapper.user.UserInfoMapper
import com.easipos.template.models.Result
import com.easipos.template.models.UserInfo

class UserDataRepository(private val dataFactory: DataFactory) : UserRepository {

    private val userInfoMapper by lazy { UserInfoMapper() }

    override suspend fun getUserInfo(model: BasicRequestModel): Result<UserInfo?> =
        dataFactory.createUserDataSource()
            .getUserInfo(model, userInfoMapper)

    override suspend fun updateUserInfo(model: UpdateProfileRequestModel): Result<Nothing> =
        dataFactory.createUserDataSource()
            .updateUserInfo(model)
}