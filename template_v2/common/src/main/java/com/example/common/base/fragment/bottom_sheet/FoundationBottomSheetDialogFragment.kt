package com.example.common.base.fragment.bottom_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class FoundationBottomSheetDialogFragment(
    @LayoutRes private val layoutRes: Int
) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(savedInstanceState)
    }

    override fun getTheme(): Int {
        return R.style.ThemeOverlay_MyTheme_BottomSheetDialog
    }

    /**
     *  To initialise views.
     */
    abstract fun initViews()

    /**
     *  To initialise listeners.
     */
    abstract fun initListeners()

    /**
     *  Call from {@link androidx.fragment.app.Fragment#onViewCreated} to reduce boilerplate.
     */
    @CallSuper
    open fun init(savedInstanceState: Bundle?) {
        initViews()
        initListeners()
    }
}