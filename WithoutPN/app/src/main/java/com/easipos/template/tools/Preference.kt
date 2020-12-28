package com.easipos.template.tools

import com.pixplicity.easyprefs.library.Prefs

object Preference {

    private const val PREF_LANGUAGE_CODE = "PREF_LANGUAGE_CODE"
    private const val PREF_ACCESS_TOKEN = "PREF_ACCESS_TOKEN"
    private const val PREF_IS_LOGGED_IN = "PREF_IS_LOGGED_IN"

    var prefLanguageCode: String
        get() = Prefs.getString(PREF_LANGUAGE_CODE, "en")
        set(languageCode) = Prefs.putString(PREF_LANGUAGE_CODE, languageCode)

    var prefAccessToken: String
        get() = Prefs.getString(PREF_ACCESS_TOKEN, "")
        set(accessToken) = Prefs.putString(PREF_ACCESS_TOKEN, accessToken)

    var prefIsLoggedIn: Boolean
        get() = Prefs.getBoolean(PREF_IS_LOGGED_IN, false)
        set(isLoggedIn) = Prefs.putBoolean(PREF_IS_LOGGED_IN, isLoggedIn)

    fun logout() {
        prefIsLoggedIn = false

        Prefs.remove(PREF_ACCESS_TOKEN)
    }
}