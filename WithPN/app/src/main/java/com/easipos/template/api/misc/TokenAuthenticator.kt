package com.easipos.template.api.misc

import com.easipos.template.Easi
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

/**
 *  A class used intercept request to refresh token when response code is 401
 */
class TokenAuthenticator(private val easi: Easi) : Authenticator {

    override fun authenticate(route: Route?, response: Response?): Request? {
        response?.let {
            if (response.code() == 401) {
                easi.restartAndGotoOnboarding()
            }
        }

        return null
    }
}