package com.example.template_v2.main.splash

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.common.util.ext.asyncIO
import com.example.common.base.viewmodel.BaseViewModel
import com.example.lib_data_source.model.AuthModel
import com.example.lib_data_source.preference.IAppSharedPreference
import com.example.lib_data_source.preference.SPKey
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    application: Application
) : BaseViewModel<String>(application) {

    @Inject
    lateinit var sharedPreference: IAppSharedPreference

    private val _state = MutableStateFlow<SplashState>(SplashState.Init)
    internal val state: StateFlow<SplashState>
        get() = _state

    override fun start(args: String?) {
        // Todo: To remove hardcoded AuthModel
        sharedPreference.saveObject(
            AuthModel::class.java,
            SPKey.KEY_AUTH_MODEL,
            AuthModel(
                accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3FhLmdldHlpcHBpLmNvbS9hcGkvdjIvYXV0aC9sb2dpbiIsImlhdCI6MTYyMzg0MTcyMCwiZXhwIjo3MzAwMzIxNzIwLCJuYmYiOjE2MjM4NDE3MjAsImp0aSI6Im9Ub0t1cXZYUWVHY3V3UnoiLCJzdWIiOjIwMDAwNjMsInBydiI6IjQ4ZTQ1MzgzMWNlYmE1ZTU3YTQ3NWU2ODY0OWNmZGVlNmU5N2Q4ZDIifQ.Y5Dn2Yj83Q1Dx0a_s0FhzJdJ_tT56kxYV6aIRpxrHw8",
                tokenType = null,
                expires = null,
                refreshTtl = null,
                IMToken = null,
                username = null
            )
        )

        performInitialAction()
    }

    private fun performInitialAction() {
        viewModelScope.launch {
            mutableListOf(
                asyncIO { systemRepository.getBootstrappersInfo() },
            ).awaitAll()

            _state.value = SplashState.InitialActionCompleted
        }
    }
}