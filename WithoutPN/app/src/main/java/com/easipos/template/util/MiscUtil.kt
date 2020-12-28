package com.easipos.template.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

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