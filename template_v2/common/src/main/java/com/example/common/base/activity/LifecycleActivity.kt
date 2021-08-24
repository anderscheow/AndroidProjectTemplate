package com.example.common.base.activity

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModelProvider
import com.example.common.base.viewmodel.BaseViewModel

/**
 *  Used for Lifecycle activity.
 */
abstract class LifecycleActivity<VM : BaseViewModel<*>>(clazz: Class<VM>) : FoundationActivity() {

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
    }
}
