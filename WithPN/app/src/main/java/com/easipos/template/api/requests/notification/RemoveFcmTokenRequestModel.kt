package com.easipos.template.api.requests.notification

import com.easipos.template.api.requests.BasicRequestModel
import okhttp3.MultipartBody

class RemoveFcmTokenRequestModel(
    val registrationID: String
)