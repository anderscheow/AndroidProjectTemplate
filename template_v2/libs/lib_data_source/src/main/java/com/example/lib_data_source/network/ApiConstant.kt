package com.example.lib_data_source.network

object ApiConstant {

    const val APP_DOMAIN = "http://example.com/"

    private const val API_VERSION_2 = "api/v2"

    /**
     *  System
     */
    const val APP_PATH_GET_BOOTSTRAPERS_INFO = "$API_VERSION_2/bootstrappers"

    /**
     *  Auth
     */
    const val APP_PATH_LOGIN = "$API_VERSION_2/auth/login"
    const val APP_PATH_REFRESH_TOKEN = "$API_VERSION_2/auth/refresh"
}