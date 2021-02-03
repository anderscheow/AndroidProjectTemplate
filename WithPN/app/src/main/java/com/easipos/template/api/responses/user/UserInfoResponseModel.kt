package com.easipos.template.api.responses.user

data class UserInfoResponseModel(
    val uid: String?,
    val name: String?,
    val email: String?,
    val phoneNumber: String?
)