package com.easipos.template.api.requests.precheck

import com.easipos.template.BuildConfig
import com.easipos.template.api.requests.RequestModel
import okhttp3.MultipartBody

class CheckVersionRequestModel: RequestModel() {

    override fun toFormDataBuilder(): MultipartBody.Builder {
        return super.toFormDataBuilder()
            .addFormDataPart("version", BuildConfig.VERSION_CODE.toString())
            .addFormDataPart("app", "ddcard")
            .addFormDataPart("os", "android")
    }
}