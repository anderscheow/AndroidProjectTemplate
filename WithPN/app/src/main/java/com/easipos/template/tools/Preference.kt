package com.easipos.template.tools

import com.pixplicity.easyprefs.library.Prefs

object Preference {

    private const val PREF_LANGUAGE_CODE = "PREF_LANGUAGE_CODE"
    private const val PREF_ACCESS_TOKEN = "PREF_ACCESS_TOKEN"
    private const val PREF_IS_LOGGED_IN = "PREF_IS_LOGGED_IN"
    private const val PREF_IS_FCM_REGISTERED = "PREF_IS_FCM_REGISTERED"
    private const val PREF_FCM_TOKEN = "PREF_FCM_TOKEN"
    private const val PREF_NOTIFICATION_COUNT = "PREF_NOTIFICATION_COUNT"

    var prefLanguageCode: String
        get() = Prefs.getString(PREF_LANGUAGE_CODE, "en")
        set(languageCode) = Prefs.putString(PREF_LANGUAGE_CODE, languageCode)

    var prefAccessToken: String
        get() = Prefs.getString(PREF_ACCESS_TOKEN, "")
        set(accessToken) = Prefs.putString(PREF_ACCESS_TOKEN, accessToken)

    var prefIsLoggedIn: Boolean
        get() = Prefs.getBoolean(PREF_IS_LOGGED_IN, false)
        set(isLoggedIn) = Prefs.putBoolean(PREF_IS_LOGGED_IN, isLoggedIn)

    var prefIsFcmTokenRegistered: Boolean
        get() = Prefs.getBoolean(PREF_IS_FCM_REGISTERED, false)
        set(isRegistered) = Prefs.putBoolean(PREF_IS_FCM_REGISTERED, isRegistered)

    var prefFcmToken: String
        get() = Prefs.getString(PREF_FCM_TOKEN, "")
        set(token) = Prefs.putString(PREF_FCM_TOKEN, token)

    var prefNotificationCount: Int
        get() = Prefs.getInt(PREF_NOTIFICATION_COUNT, 0)
        set(count) = Prefs.putInt(PREF_NOTIFICATION_COUNT, count)

    fun logout() {
        prefIsLoggedIn = false
        prefIsFcmTokenRegistered = false
        prefNotificationCount = 0

        Prefs.remove(PREF_ACCESS_TOKEN)
    }
}