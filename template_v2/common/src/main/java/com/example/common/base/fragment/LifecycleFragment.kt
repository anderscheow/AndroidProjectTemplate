package com.example.common.base.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.common.base.viewmodel.BaseViewModel

/**
 *  Used for Lifecycle fragment.
 */
abstract class LifecycleFragment<VM : BaseViewModel<*>>(
    @LayoutRes layoutRes: Int,
    clazz: Class<VM>
) : FoundationFragment(layoutRes) {

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
    }

    /**
     *  Used to trigger [BaseViewModel.onRefresh].
     */
    open fun refresh() {
        viewModel.onRefresh()
    }
}
