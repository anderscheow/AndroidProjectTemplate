package com.easipos.template.datasource.user

import com.easipos.template.api.misc.parseException
import com.easipos.template.api.misc.parseResponse
import com.easipos.template.api.requests.BasicRequestModel
import com.easipos.template.api.requests.user.UpdateProfileRequestModel
import com.easipos.template.api.services.Api
import com.easipos.template.mapper.user.UserInfoMapper
import com.easipos.template.models.Result
import com.easipos.template.models.UserInfo
import com.easipos.template.room.RoomService

class UserDataSource(private val api: Api, private val roomService: RoomService) : UserDataStore {

    override suspend fun getUserInfo(
        model: BasicRequestModel,
        userInfoMapper: UserInfoMapper
    ): Result<UserInfo?> {
        return try {
            val response = api.getUserInfo(model)
            parseResponse(response) {
                val data = userInfoMapper.transform(it)

                roomService.userDao().insertUserInfo(data)

                data
            }
        } catch (ex: Exception) {
            roomService.userDao().findUserInfo()?.let {
                Result.Success(it)
            } ?: run {
                parseException(ex)
            }
        }
    }

    override suspend fun updateUserInfo(model: UpdateProfileRequestModel): Result<Nothing> {
        return try {
            val response = api.updateUserProfile(model)
            parseResponse(response) {
                roomService.userDao().findUserInfo()?.let { userInfo ->
                    roomService.userDao().updateUserInfo(userInfo.copy(
                        name = model.name,
                        phoneNumber = model.phoneNumber,
                        email = model.email,
                    ))
                }
            }
        } catch (ex: Exception) {
            parseException(ex)
        }
    }
}
