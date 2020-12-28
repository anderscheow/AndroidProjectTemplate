package com.easipos.template.fragments.alert_dialog

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AlertDialog
import com.easipos.template.R
import io.github.anderscheow.library.appCompat.activity.BaseActivity
import io.github.anderscheow.library.kotlinExt.click
import kotlinx.android.synthetic.main.alert_dialog_common.*

class CommonAlertDialog(context: Context,
                        private val message: CharSequence,
                        private val action: (() -> Unit)? = null) : AlertDialog(context) {

    companion object {
        fun show(activity: BaseActivity, message: CharSequence, action: (() -> Unit)?) {
            activity.displayAlertDialog {
                CommonAlertDialog(
                    activity,
                    message,
                    action
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alert_dialog_common)

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        text_view_message.text = message

        button_ok.click {
            action?.invoke()
            dismiss()
        }
    }
}