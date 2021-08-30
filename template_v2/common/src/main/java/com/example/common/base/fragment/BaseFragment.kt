package com.example.common.base.fragment

import androidx.annotation.LayoutRes

/**
 *  Used for non-Lifecycle fragment.
 */
abstract class BaseFragment(
    @LayoutRes layoutRes: Int
) : FoundationFragment(layoutRes)
