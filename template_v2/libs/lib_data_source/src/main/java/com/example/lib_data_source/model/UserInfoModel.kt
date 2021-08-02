package com.example.lib_data_source.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInfoModel(
    @Json(name = "id")
    val id: Long,

    @Json(name = "name")
    val name: String?,

    @Json(name = "username")
    val username: String?,

    @Json(name = "fullname")
    val fullName: String?
) : Parcelable