package com.easipos.template.base

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import io.github.anderscheow.library.appCompat.fragment.BaseDialogFragment

abstract class CustomBaseDialogFragment : BaseDialogFragment() {

    override fun show(manager: FragmentManager, tag: String?) {
        try {
            val ft = manager.beginTransaction()
            ft.add(this, tag)
            ft.commitAllowingStateLoss()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, 0)
    }
}
