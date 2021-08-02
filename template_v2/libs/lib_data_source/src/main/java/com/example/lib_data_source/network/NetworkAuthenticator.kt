package com.example.lib_data_source.network

import android.content.Context
import com.example.lib_data_source.preference.IAppSharedPreference
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class NetworkAuthenticator @Inject constructor(
    @ApplicationContext private val context: Context,
    private val sharedPreference: IAppSharedPreference
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        // Todo: Implement token refresh
        return response.request
    }
}