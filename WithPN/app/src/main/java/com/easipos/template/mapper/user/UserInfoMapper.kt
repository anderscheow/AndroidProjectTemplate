package com.easipos.template.mapper.user

import com.easipos.template.api.responses.user.UserInfoResponseModel
import com.easipos.template.mapper.Mapper
import com.easipos.template.models.UserInfo

class UserInfoMapper : Mapper<UserInfo, UserInfoResponseModel>() {

    override fun transform(item: UserInfoResponseModel): UserInfo {
        return UserInfo(
            uid = item.uid ?: "",
            name = item.name ?: "",
            email = item.email ?: "",
            phoneNumber = item.phoneNumber ?: "",
        )
    }
}