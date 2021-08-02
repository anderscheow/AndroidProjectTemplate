package com.example.common.util.ext

import android.os.Handler
import android.os.Looper

/**
 *  Simplified delay function.
 *
 *  @param timeInMillis Time in milliseconds.
 *  @param block Callback to invoke after a period of time.
 */
fun delay(timeInMillis: Long, block: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed(block, timeInMillis)
}

/**
 *  Return current class name
 */
val <T : Any> T.TAG
    get() = this::class.simpleName!!

