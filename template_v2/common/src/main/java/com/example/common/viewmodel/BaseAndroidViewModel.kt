package com.example.common.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.common.repository.auth_repository.IAuthRepository
import com.example.common.repository.system_repository.ISystemRepository
import com.example.common.viewmodel.util.AlertDialogData
import com.example.common.viewmodel.util.AlertDialogMessageEvent
import com.example.common.viewmodel.util.ProgressDialogMessageEvent
import com.example.common.viewmodel.util.ToastMessageEvent
import javax.inject.Inject

abstract class BaseAndroidViewModel<in Args>(application: Application) :
    AndroidViewModel(application) {

    @Inject
    lateinit var systemRepository: ISystemRepository

    @Inject
    lateinit var authRepository: IAuthRepository

    val isLoading by lazy { MutableLiveData(false) }

    val toastMessageEvent = ToastMessageEvent()
    val progressDialogMessageEvent = ProgressDialogMessageEvent()
    val alertDialogMessageEvent = AlertDialogMessageEvent()

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
     * Called to show or dismiss progress dialog.
     *
     * @param value If value is null, dialog dismiss, otherwise display.
     */
    protected fun showProgressDialog(value: Any?) {
        progressDialogMessageEvent.postValue(value)
    }

    /**
     * Called to dismiss progress dialog
     */
    protected fun dismissProgressDialog() {
        progressDialogMessageEvent.postValue(null)
    }

    /**
     * Called to show toast.
     *
     * @param message Message to display in toast.
     */
    protected fun showToast(message: Any) {
        toastMessageEvent.postValue(message)
    }

    /**
     * Called to show alert dialog.
     *
     * @param data Message to display in alert dialog.
     */
    protected fun showAlertDialog(data: AlertDialogData) {
        alertDialogMessageEvent.postValue(data)
    }

    /**
     * Called to set loading.
     *
     * @param value Boolean to show or hide loading.
     */
    protected fun setIsLoading(value: Boolean) {
        isLoading.postValue(value)
    }

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
