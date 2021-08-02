package com.example.lib_data_source.model

import com.squareup.moshi.Json

data class AuthModel(
    @Json(name = "access_token")
    val accessToken: String?,

    @Json(name = "token_type")
    val tokenType: String?,

    @Json(name = "expires_in")
    val expires: Long?,

    @Json(name = "refresh_ttl")
    val refreshTtl: Long?,

    @Json(name = "netease_token")
    val IMToken: String?,

    @Json(name = "username")
    val username: String?,
)