package com.example.common.base.activity

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModelProvider
import com.example.common.viewmodel.BaseAndroidViewModel
import com.example.common.viewmodel.util.AlertDialogData
import com.example.common.viewmodel.util.AlertDialogMessageEvent
import com.example.common.viewmodel.util.ProgressDialogMessageEvent
import com.example.common.viewmodel.util.ToastMessageEvent

/**
 *  Used for Lifecycle activity.
 */
abstract class LifecycleActivity<VM : BaseAndroidViewModel<*>>(clazz: Class<VM>) :
    com.example.common.base.activity.FoundationActivity() {

    protected val viewModel: VM by lazy {
        ViewModelProvider(this).get(clazz)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModelObserver()
    }

    /**
     *  Used to observe Observer in ViewModel.
     */
    @CallSuper
    open fun setupViewModelObserver() {
        setupProgressDialogEventObserver()
        setupToastEventObserver()
        setupAlertDialogEventObserver()
    }

    /**
     *  Setup and listen to progress dialog message event.
     */
    private fun setupProgressDialogEventObserver() {
        viewModel.progressDialogMessageEvent.observe(
            this,
            object : ProgressDialogMessageEvent.ProgressDialogObserver {
                override fun onNewMessage(message: Int) {
                    // Todo: Show progress dialog
                }

                override fun onNewMessage(message: String) {
                    // Todo: Show progress dialog
                }

                override fun dismiss() {
                    // Todo: Dismiss progress dialog
                }
            })
    }

    /**
     *  Setup and listen to toast message event.
     */
    private fun setupToastEventObserver() {
        viewModel.toastMessageEvent.observe(this, object : ToastMessageEvent.ToastObserver {
            override fun onNewMessage(message: String) {
                // Todo: Show toast
            }

            override fun onNewMessage(message: Int) {
                // Todo: Show toast
            }
        })
    }

    /**
     *  Setup and listen to alert dialog message event.
     */
    private fun setupAlertDialogEventObserver() {
        viewModel.alertDialogMessageEvent.observe(
            this,
            object : AlertDialogMessageEvent.AlertDialogObserver {
                override fun onNewMessage(data: AlertDialogData) {
                    // Todo: Show alert dialog
                }
            })
    }
}
