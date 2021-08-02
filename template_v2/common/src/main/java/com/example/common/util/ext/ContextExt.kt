package com.example.common.util.ext

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.location.LocationManager
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

object ContextExt {
    @JvmStatic
    fun px(context: Context, dip: Float): Int {
        return context.px(dip)
    }
}

/**
 *  Get color from [ContextCompat].
 *
 *  @param resId Color resource id.
 *
 *  @return A single color value in the form 0xAARRGGBB.
 */
fun Context.findColor(@ColorRes resId: Int) = ContextCompat.getColor(this, resId)

/**
 *  Get color state list from [ContextCompat].
 *
 *  @param resId Color resource id.
 *
 *  @return A single color value in the form 0xAARRGGBB.
 */
fun Context.findColorStateList(@ColorRes resId: Int) = ContextCompat.getColorStateList(this, resId)

/**
 *  Get drawable from [ContextCompat].
 *
 *  @param resId Drawable resource id.
 *
 *  @return An object that can be used to draw this resource.
 */
fun Context.findDrawable(@DrawableRes resId: Int): Drawable? =
    ContextCompat.getDrawable(this, resId)

/**
 * Display the simple Toast message with the [Toast.LENGTH_SHORT] duration.
 *
 * @param message the message text resource.
 */
fun Context.toast(message: Int): Toast = Toast
    .makeText(this, message, Toast.LENGTH_SHORT)
    .apply {
        show()
    }

/**
 * Display the simple Toast message with the [Toast.LENGTH_SHORT] duration.
 *
 * @param message the message text.
 */
fun Context.toast(message: CharSequence): Toast = Toast
    .makeText(this, message, Toast.LENGTH_SHORT)
    .apply {
        show()
    }

/**
 * Display the simple Toast message with the [Toast.LENGTH_LONG] duration.
 *
 * @param message the message text resource.
 */
fun Context.longToast(message: Int): Toast = Toast
    .makeText(this, message, Toast.LENGTH_LONG)
    .apply {
        show()
    }

/**
 * Display the simple Toast message with the [Toast.LENGTH_LONG] duration.
 *
 * @param message the message text.
 */
fun Context.longToast(message: CharSequence): Toast = Toast
    .makeText(this, message, Toast.LENGTH_LONG)
    .apply {
        show()
    }

/**
 * Convert dp to px.
 *
 * @param dp Dp in float.
 *
 * @return Value in px.
 */
fun Context.px(dp: Float): Int {
    return (dp * resources.displayMetrics.density + 0.5f).toInt()
}

/**
 * Convert px to dp.
 *
 * @param px Px in float.
 *
 * @return Value in dp.
 */
fun Context.dp(px: Float): Int {
    return (px / resources.displayMetrics.density + 0.5f).toInt()
}

/**
 *  Check is gps enable.
 *
 *  @return Gps enable status.
 */
fun Context.isGpsEnabled(): Boolean {
    return (this.getSystemService(Context.LOCATION_SERVICE) as LocationManager).isProviderEnabled(
        LocationManager.GPS_PROVIDER
    )
}

/**
 *  Go to Location section in Settings.
 */
fun Context.gotoLocationSetting() {
    try {
        val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS).apply {
            this.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        this.startActivity(intent)
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}