package com.easipos.template.managers

import android.content.Intent
import com.easipos.template.Easi
import com.easipos.template.activities.main.MainActivity
import com.easipos.template.activities.splash.SplashActivity
import com.easipos.template.services.PushNotificationService
import com.easipos.template.util.showAlerter
import com.orhanobut.logger.Logger
import org.json.JSONObject

class PushNotificationManager(val service: PushNotificationService) {

    companion object {
        const val FCM_TITLE = "pn_title"
        const val FCM_BODY = "pn_body"
        const val FCM_CATEGORY = "pn_category"
    }

    var payload: Payload? = null
        private set

    fun removePayload() {
        payload = null
    }

    fun receiveNotification(easi: Easi, jsonObject: JSONObject, isActivityVisible: Boolean) {
        if (isActivityVisible) {
            showAlerter(easi, this, jsonObject)
        }
        easi.mainActivity?.let { mainActivity ->
            refreshContentBasedOnCategory(mainActivity, jsonObject)
        }
    }

    fun openNotification(easi: Easi, jsonObject: JSONObject?, isActivityVisible: Boolean) {
        if (jsonObject != null) {
            if (jsonObject.has(FCM_CATEGORY)) {
                payload = Payload(jsonObject[FCM_CATEGORY] as String)

                if (isActivityVisible) {
                    easi.mainActivity?.processPayload()
                } else {
                    val intent = SplashActivity.newIntent(easi).apply {
                        this.flags =
                            Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                    easi.startActivity(intent)
                }
            }
        }
    }

    /**
     *  Refresh content based on notification category
     */
    private fun refreshContentBasedOnCategory(mainActivity: MainActivity, jsonObject: JSONObject) {
        try {
//            mainActivity.updateNotifications()

            if (jsonObject.has(FCM_CATEGORY)) {
                val notificationType = jsonObject.get(FCM_CATEGORY) as? String

                if (UserManager.token != null && notificationType != null) {
//                    when (notificationType) {
//                        NotificationCategory.POINT_ADJUSTMENT,
//                        NotificationCategory.POINT_DEDUCTION,
//                        NotificationCategory.POINT_ISSUANCE,
//                        NotificationCategory.POINT_EXPIRY -> {
//                            mainActivity.refreshUserInfo()
//                        }
//
//                        NotificationCategory.REWARD_REDEMPTION,
//                        NotificationCategory.PURCHASE -> {
//                            mainActivity.refreshUserInfo()
//                            mainActivity.refreshTransactionHistory()
//                        }
//                    }
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
//            Crashlytics.logException(ex)
        }
    }

    private fun finishAllActivitiesExceptMainActivity() {
        try {
            for (activity in Easi.activities) {
                Logger.d(activity)
                if (activity !is MainActivity) {
                    activity.finish()
                }
            }
        } catch (ex: Exception) {
//            Crashlytics.logException(ex)
            ex.printStackTrace()
        }
    }

    inner class Payload internal constructor(category: String) {

        var category: String? = category
            private set

        override fun toString(): String {
            return "Payload(category=$category)"
        }
    }
}