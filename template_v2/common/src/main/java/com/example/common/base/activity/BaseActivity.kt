package com.example.common.base.activity

import androidx.annotation.LayoutRes

/**
 *  Used for non-Lifecycle activity.
 */
abstract class BaseActivity(
    @LayoutRes layoutRes: Int
) : FoundationActivity(layoutRes)
