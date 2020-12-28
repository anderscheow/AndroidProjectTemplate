package com.easipos.template.services

import android.os.AsyncTask
import com.easipos.template.Easi
import com.easipos.template.api.requests.notification.RegisterFcmTokenRequestModel
import com.easipos.template.api.requests.notification.RemoveFcmTokenRequestModel
import com.easipos.template.managers.UserManager
import com.easipos.template.models.Result
import com.easipos.template.repositories.notification.NotificationRepository
import com.easipos.template.tools.Preference
import com.google.firebase.iid.FirebaseInstanceId
import com.orhanobut.logger.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.kodein.di.instance
import java.io.IOException
import kotlin.coroutines.CoroutineContext

class FcmService(easi: Easi) : CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    private val notificationRepository by easi.instance<NotificationRepository>()

    fun saveFcmToken(fcmToken: String) {
        Logger.d("saveFcmToken: $fcmToken")

        synchronized(this) {
            Preference.prefFcmToken = fcmToken

            // Register FCM Token in MainActivity
            Preference.prefIsFcmTokenRegistered = false

            registerFcmToken()
        }
    }

    fun registerFcmToken() {
        if (Preference.prefIsLoggedIn) {
            val fcmToken = Preference.prefFcmToken

            if (fcmToken.isNotBlank()) {
                UserManager.token?.let {
                    Logger.d("registerFcmToken: Registering fcm token with {$fcmToken}")

                    val model = RegisterFcmTokenRequestModel(fcmToken)

                    launch {
                        when (val result = notificationRepository.registerFcmToken(model)) {
                            is Result.EmptySuccess -> {
                                Logger.i("registerFcmToken: Fcm token registered")
                                Preference.prefIsFcmTokenRegistered = true
                            }

                            is Result.Error -> {
                                Logger.e("registerFcmToken: " + result.exception.message)
                                Preference.prefIsFcmTokenRegistered = false
                            }

                            else -> {
                            }
                        }
                    }
                }
            }
        }
    }

    fun removeFcmToken() {
        val fcmToken = Preference.prefFcmToken

        if (fcmToken.isNotBlank()) {
            Logger.d("removeFcmToken: Removing fcm token with {$fcmToken}")

            UserManager.token?.let {
                val model = RemoveFcmTokenRequestModel(fcmToken)

                launch {
                    when (val result = notificationRepository.removeFcmToken(model)) {
                        is Result.EmptySuccess -> {
                            Logger.i("removeFcmToken: Fcm token removed")
                        }

                        is Result.Error -> {
                            Logger.e("removeFcmToken: " + result.exception.message)
                        }

                        else -> {
                        }
                    }
                }
            }
        }
    }

    fun resetFcmToken() {
        // Do not need to reset when using OneSignal
        //ResetFcmTokenAsyncTask().execute()
    }

    private class ResetFcmTokenAsyncTask : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg voids: Void): Void? {
            Logger.d("resetFcmToken: Deleting fcm instance id")
            try {
                FirebaseInstanceId.getInstance().deleteInstanceId()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return null
        }
    }
}