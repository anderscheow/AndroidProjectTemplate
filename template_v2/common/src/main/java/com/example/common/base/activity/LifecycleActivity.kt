package com.example.common.base.activity

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.common.base.viewmodel.BaseViewModel

/**
 *  Used for Lifecycle activity.
 */
abstract class LifecycleActivity<VM : BaseViewModel<*>>(
    @LayoutRes layoutRes: Int,
    clazz: Class<VM>
) : FoundationActivity(layoutRes) {

    protected val viewModel: VM by lazy {
        ViewModelProvider(this).get(clazz)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModelObserver(this)
    }

    /**
     *  Used to observe Observer in ViewModel.
     */
    @CallSuper
    open fun setupViewModelObserver(lifecycleOwner: LifecycleOwner) {
    }
}
