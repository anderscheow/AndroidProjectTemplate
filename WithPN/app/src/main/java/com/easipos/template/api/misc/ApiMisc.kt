package com.easipos.template.api.misc

import android.os.Build
import com.easipos.template.BuildConfig
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import okhttp3.*
import okhttp3.internal.platform.Platform
import java.util.*
import java.util.concurrent.TimeUnit

const val USER_AGENT = "User-Agent"
const val AUTHORISATION = "Authorization"

val loggingInterceptor: LoggingInterceptor
    get() = LoggingInterceptor.Builder()
            .loggable(BuildConfig.DEBUG)
            .setLevel(Level.BASIC)
            .log(Platform.INFO)
            .request("Request")
            .response("Response")
            .build()

private val legacyTls = ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
        .cipherSuites(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA)
        .build()

fun addTlsSpec(okHttpClientBuilder: OkHttpClient.Builder): OkHttpClient {
    if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
        okHttpClientBuilder.connectionSpecs(Arrays.asList(legacyTls, ConnectionSpec.CLEARTEXT))
    }

    return okHttpClientBuilder.build()
}

fun constructOkhttpClient(additionalInterceptors: List<Interceptor>, authenticator: Authenticator? = null): OkHttpClient {
    return addTlsSpec(OkHttpClient.Builder()
        .apply {
            additionalInterceptors.forEach {
                this.addInterceptor(it)
            }
        }
        .addInterceptor(loggingInterceptor)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS).apply {
            authenticator?.let {
                this.authenticator(authenticator)
            }
        })
}
