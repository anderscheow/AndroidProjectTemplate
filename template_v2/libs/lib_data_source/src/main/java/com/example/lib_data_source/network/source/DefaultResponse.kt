package com.example.lib_data_source.network.source

import com.squareup.moshi.Json

data class DefaultResponse(
    @Json(name = "message")
    val message: Any?,

    @Json(name = "id")
    val id: Long?
)