package com.example.template_v2.main.login

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.common.repository.auth_repository.IAuthRepository
import com.example.common.viewmodel.BaseAndroidViewModel
import com.example.lib_data_source.model.AuthModel
import com.example.lib_data_source.network.source.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application,
    authRepository: IAuthRepository
) : BaseAndroidViewModel<String>(application) {

    internal val test: LiveData<Resource<AuthModel>> =
        authRepository.login()
            .onStart { emit(Resource.Loading) }
            .asLiveData()

    override fun start(args: String?) {
    }
}