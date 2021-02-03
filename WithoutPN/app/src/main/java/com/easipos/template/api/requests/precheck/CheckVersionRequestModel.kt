package com.easipos.template.api.requests.precheck

import com.easipos.template.BuildConfig

data class CheckVersionRequestModel(
    val version: String = BuildConfig.VERSION_CODE.toString(),
    val app: String = "ddcard",
    val os: String = "android",
)