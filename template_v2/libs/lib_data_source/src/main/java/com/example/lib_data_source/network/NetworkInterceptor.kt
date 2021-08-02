package com.example.lib_data_source.network

import android.content.Context
import android.content.pm.PackageInfo
import android.os.Build
import android.provider.Settings
import com.example.lib_data_source.model.AuthModel
import com.example.lib_data_source.preference.IAppSharedPreference
import com.example.lib_data_source.preference.SPKey
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


class NetworkInterceptor @Inject constructor(
    @ApplicationContext private val context: Context,
    private val sharedPreference: IAppSharedPreference
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var clientVersion = ""
        var accessToken = ""
//        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager?
//        val deviceId = telephonyManager!!.imei

        val deviceId = Settings.Secure.getString(
            context.contentResolver,
            Settings.Secure.ANDROID_ID
        )
        try {
            val packageInfo: PackageInfo =
                context.packageManager.getPackageInfo(context.packageName, 0)
            clientVersion = packageInfo.versionName
        } catch (e: Exception) {
            e.printStackTrace()
        }

        sharedPreference.getObject(AuthModel::class.java, SPKey.KEY_AUTH_MODEL)?.let { authModel ->
            accessToken = "Bearer ${authModel.accessToken}"
        }

//        if (YippiApplication.getMyUserIdWithdefault() > 0) {
//            headers.put(
//                "X-Request-ID", YippiApplication.getMyUserIdWithdefault().toString() +
//                        System.currentTimeMillis() / 1000
//            )
//        }
//        authRepository.get().test()
        val request = chain.request()
            .newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("Authorization", accessToken)
            .addHeader("Accept-Language", "en-GB")
            .addHeader("X-Client-Type", "and")
            .addHeader("X-Device-OS", "Api-" + Build.VERSION.SDK_INT)
            .addHeader("X-Client-Version", clientVersion)
            .addHeader("X-Device-Model", Build.MANUFACTURER + " - " + Build.MODEL)
            .addHeader("X-Device-ID", deviceId)
            .build()

        return chain.proceed(request)
    }
}