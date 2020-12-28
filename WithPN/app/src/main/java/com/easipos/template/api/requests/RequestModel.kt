package com.easipos.template.api.requests

import com.easipos.template.managers.UserManager
import okhttp3.MultipartBody

open class RequestModel(var apiKey: String? = UserManager.token?.token) {

    open fun toFormDataBuilder(): MultipartBody.Builder {
        val builder = MultipartBody.Builder()
            .setType(MultipartBody.FORM)

        if (apiKey != null) {
            builder.addFormDataPart("apiKey", apiKey!!)
        }

        return builder
    }
}