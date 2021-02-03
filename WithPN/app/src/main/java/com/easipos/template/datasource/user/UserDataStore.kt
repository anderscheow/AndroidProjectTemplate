package com.easipos.template.datasource.user

import com.easipos.template.api.requests.BasicRequestModel
import com.easipos.template.api.requests.notification.RegisterFcmTokenRequestModel
import com.easipos.template.api.requests.notification.RemoveFcmTokenRequestModel
import com.easipos.template.api.requests.user.UpdateProfileRequestModel
import com.easipos.template.mapper.user.UserInfoMapper
import com.easipos.template.models.Result
import com.easipos.template.models.UserInfo

interface UserDataStore {

    suspend fun getUserInfo(model: BasicRequestModel, userInfoMapper: UserInfoMapper): Result<UserInfo?>

    suspend fun updateUserInfo(model: UpdateProfileRequestModel): Result<Nothing>
}
