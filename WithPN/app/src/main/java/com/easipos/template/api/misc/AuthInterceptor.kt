package com.easipos.template.api.misc

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor(private val userAgent: String, private val authorisation: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authenticatedRequest: Request = request.newBuilder()
//                .header(USER_AGENT, userAgent)
//                .header(AUTHORISATION, authorisation)
                .build()
        return chain.proceed(authenticatedRequest)
    }
}
