package com.easipos.template.api.requests

import com.easipos.template.managers.UserManager

data class BasicRequestModel(
    val apiKey: String? = UserManager.token?.token
)