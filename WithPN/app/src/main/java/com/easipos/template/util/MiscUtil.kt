package com.easipos.template.util

import android.app.Activity
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.easipos.template.Easi
import com.easipos.template.R
import com.easipos.template.managers.PushNotificationManager
import com.easipos.template.managers.PushNotificationManager.Companion.FCM_BODY
import com.easipos.template.managers.PushNotificationManager.Companion.FCM_TITLE
import com.easipos.template.tools.Preference
import com.tapadoo.alerter.Alerter
import io.github.anderscheow.library.kotlinExt.findColor
import org.json.JSONObject

val languages = mapOf("zh" to "中文", "en" to "English")

fun defaultRequestOption(): RequestOptions {
    return RequestOptions()
}

fun ImageView.loadImage(imageUrl: String) {
    Glide.with(this.context)
        .load(imageUrl)
        .apply(defaultRequestOption())
        .transition(DrawableTransitionOptions().crossFade(500))
        .into(this)
}

fun showAlerter(easi: Easi, pushNotificationManager: PushNotificationManager, jsonObject: JSONObject) {
    jsonObject.takeIf {
        jsonObject.has(FCM_TITLE) && jsonObject.has(FCM_BODY)
    }.run {
        this?.let { data ->
            easi.currentActivity?.let { activity ->
                Alerter.create(activity)
                    .setTitle(data.getString(FCM_TITLE) ?: "")
                    .setText(data.getString(FCM_BODY) ?: "")
                    .setBackgroundColorInt(activity.findColor(R.attr.colorSecondary))
                    .setDuration(5000)
                    .setIconColorFilter(Color.WHITE)
                    .enableSwipeToDismiss()
                    .enableVibration(true)
                    .setOnClickListener(View.OnClickListener {
                        Alerter.hide()

                        pushNotificationManager.openNotification(easi, jsonObject, true)
                    })
                    //.setOnShowListener { Tracker.trackScreen(this@CustomLifecycleActivity, Screen.IN_APP_NOTIFICATION) }
                    .show()
            }
        }
    }
}