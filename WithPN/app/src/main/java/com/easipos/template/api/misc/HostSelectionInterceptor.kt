package com.easipos.template.api.misc

import okhttp3.Interceptor
import okhttp3.Response

class HostSelectionInterceptor : Interceptor {
    @Volatile
    private var url: String? = null

    fun setHost(url: String) {
        this.url = url
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = this.url
        if (url != null) {
            val currentUrl = request.url().uri().toString()
            val publicInUrlIndex = url.indexOf("/public")
            val publicInCurrentUrlIndex = url.indexOf("/public")
            if (publicInUrlIndex != -1 && publicInCurrentUrlIndex != -1) {
                val newUrl = url.substring(0, url.indexOf("/public")) +
                        currentUrl.substring(currentUrl.indexOf("/public"), currentUrl.length)
                request = request.newBuilder()
                    .url(newUrl)
                    .build()
            }
        }
        return chain.proceed(request)
    }
}