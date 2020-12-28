package com.easipos.template.managers

import com.easipos.template.models.Auth
import com.easipos.template.tools.Preference

object UserManager {

    var token: Auth? = null
        get() {
            if (field == null) {
                field = loadToken()
            }

            return field
        }
        set(value) {
            field = value
            saveToken(value)
        }

    /**
     *  Save token
     *  Not null    ->  Save token into preference and set isLoggedIn to true
     *  Null        ->  Execute Preference.logout()
     */
    private fun saveToken(token: Auth?) {
        token?.let {
            Preference.apply {
                prefAccessToken = token.token
                prefIsLoggedIn = true
            }
        } ?: run {
            Preference.logout()
        }
    }

    private fun loadToken(): Auth? {
        if (Preference.prefAccessToken.isEmpty()) {
            return null
        }

        return Auth(
            token = Preference.prefAccessToken
        )
    }
}