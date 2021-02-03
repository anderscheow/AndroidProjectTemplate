package com.easipos.template.api.requests.user

import com.easipos.template.managers.UserManager

data class UpdateProfileRequestModel(
    val apiKey: String? = UserManager.token?.token,
    val name: String,
    val phoneNumber: String,
    val email: String
)