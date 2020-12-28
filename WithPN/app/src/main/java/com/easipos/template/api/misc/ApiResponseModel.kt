package com.easipos.template.api.misc

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

abstract class BaseResponseModel {

    @Expose
    @SerializedName("error")
    var error: Boolean = false

    @Expose
    @SerializedName("code")
    var code: Int = 0

    @Expose
    @SerializedName("message")
    lateinit var message: String
}

class ResponseModel<out T> : BaseResponseModel() {

    @Expose
    @SerializedName("data")
    val data: T? = null
}

class EmptyResponseModel : BaseResponseModel()
