package com.easipos.template.api.requests.notification

import com.easipos.template.api.requests.RequestModel
import okhttp3.MultipartBody

class RegisterFcmTokenRequestModel(private val registrationID: String): RequestModel() {

    override fun toFormDataBuilder(): MultipartBody.Builder {
        return super.toFormDataBuilder()
            .addFormDataPart("registration_id", registrationID)
            .addFormDataPart("action", "create")
            .addFormDataPart("os", "android")
            .addFormDataPart("app", "ddcard")
    }
}