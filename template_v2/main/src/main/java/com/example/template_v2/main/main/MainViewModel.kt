package com.example.template_v2.main.main

import android.app.Application
import com.example.common.repository.auth_repository.IAuthRepository
import com.example.common.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    authRepository: IAuthRepository
) : BaseViewModel<String>(application) {

    override fun start(args: String?) {

    }
}