package com.example.common.base.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.common.repository.auth_repository.IAuthRepository
import com.example.common.repository.system_repository.ISystemRepository
import javax.inject.Inject

abstract class BaseViewModel<in Args>(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var systemRepository: ISystemRepository

    @Inject
    lateinit var authRepository: IAuthRepository

    /**
     *  Default entry point for ViewModel.
     *
     *  @param args Generic type of this class
     */
    abstract fun start(args: Args? = null)

    /**
     *  Action to do when refresh is triggered.
     *
     *  Default same as start().
     */
    open fun onRefresh() = start()

    /**
     *  Check is logged in with user.
     *
     *  @return Boolean, logged in status.
     */
    protected fun isLoggedIn(): Boolean = authRepository.isLoggedIn()

    /**
     *  Check is guest mode.
     *
     *  @return Boolean, guest mode status.
     */
    protected fun isGuest(): Boolean = authRepository.isGuest()
}
