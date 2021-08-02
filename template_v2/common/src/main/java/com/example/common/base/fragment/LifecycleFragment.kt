package com.example.common.base.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.common.viewmodel.BaseAndroidViewModel
import com.example.common.viewmodel.util.AlertDialogData
import com.example.common.viewmodel.util.AlertDialogMessageEvent
import com.example.common.viewmodel.util.ProgressDialogMessageEvent
import com.example.common.viewmodel.util.ToastMessageEvent

/**
 *  Used for Lifecycle fragment.
 */
abstract class LifecycleFragment<VM : BaseAndroidViewModel<*>>(clazz: Class<VM>) :
    com.example.common.base.fragment.FoundationFragment() {

    protected val viewModel: VM by lazy {
        ViewModelProvider(this).get(clazz)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModelObserver(viewLifecycleOwner)
    }

    /**
     *  Used to observe Observer in ViewModel.
     */
    @CallSuper
    open fun setupViewModelObserver(lifecycleOwner: LifecycleOwner) {
        setupProgressDialogEventObserver(lifecycleOwner)
        setupToastEventObserver(lifecycleOwner)
        setupAlertDialogEventObserver(lifecycleOwner)
    }

    /**
     *  Used to trigger [BaseAndroidViewModel.onRefresh].
     */
    open fun refresh() {
        viewModel.onRefresh()
    }

    /**
     *  Setup and listen to progress dialog message event.
     */
    private fun setupProgressDialogEventObserver(lifecycleOwner: LifecycleOwner) {
        viewModel.progressDialogMessageEvent.observe(
            lifecycleOwner,
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
    private fun setupToastEventObserver(lifecycleOwner: LifecycleOwner) {
        viewModel.toastMessageEvent.observe(
            lifecycleOwner,
            object : ToastMessageEvent.ToastObserver {
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
    private fun setupAlertDialogEventObserver(lifecycleOwner: LifecycleOwner) {
        viewModel.alertDialogMessageEvent.observe(
            lifecycleOwner,
            object : AlertDialogMessageEvent.AlertDialogObserver {
                override fun onNewMessage(data: AlertDialogData) {
                    // Todo: Show alert dialog
                }
            })
    }
}
