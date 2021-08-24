package com.example.common.base.fragment.bottom_sheet

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.common.base.viewmodel.BaseViewModel

abstract class LifecycleBottomSheetDialogFragment<VM : BaseViewModel<*>>(clazz: Class<VM>) :
    FoundationBottomSheetDialogFragment() {

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
}
