package com.easipos.template.api.requests.notification

import com.easipos.template.api.requests.RequestModel
import okhttp3.MultipartBody

class RemoveFcmTokenRequestModel(private val registrationID: String): RequestModel() {

    override fun toFormDataBuilder(): MultipartBody.Builder {
        return super.toFormDataBuilder()
            .addFormDataPart("registration_id", registrationID)
            .addFormDataPart("action", "destroy")
            .addFormDataPart("os", "android")
            .addFormDataPart("app", "ddcard")
    }
}