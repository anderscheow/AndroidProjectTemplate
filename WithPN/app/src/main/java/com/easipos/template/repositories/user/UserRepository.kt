package com.easipos.template.repositories.user

import com.easipos.template.api.requests.BasicRequestModel
import com.easipos.template.api.requests.notification.RegisterFcmTokenRequestModel
import com.easipos.template.api.requests.notification.RemoveFcmTokenRequestModel
import com.easipos.template.api.requests.user.UpdateProfileRequestModel
import com.easipos.template.models.Result
import com.easipos.template.models.UserInfo

interface UserRepository {

    suspend fun getUserInfo(model: BasicRequestModel): Result<UserInfo?>

    suspend fun updateUserInfo(model: UpdateProfileRequestModel): Result<Nothing>
}
