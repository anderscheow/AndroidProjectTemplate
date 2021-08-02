@file:Suppress("UNCHECKED_CAST")

package com.example.common.util.ext

import android.annotation.SuppressLint
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.GestureDetectorCompat
import androidx.core.widget.TextViewCompat

/**
 *  Set view's visibility to [View.GONE].
 */
fun View.gone() {
    if (this.visibility != View.GONE) {
        this.visibility = View.GONE
    }
}

/**
 *  Set view's visibility to [View.INVISIBLE].
 */
fun View.invisible() {
    if (this.visibility != View.INVISIBLE) {
        this.visibility = View.INVISIBLE
    }
}

/**
 *  Set view's visibility to [View.VISIBLE].
 */
fun View.visible() {
    if (this.visibility != View.VISIBLE) {
        this.visibility = View.VISIBLE
    }
}

/**
 *  Enable view.
 */
fun View.enable() {
    if (this.isEnabled.not()) {
        this.isEnabled = true
    }
}

/**
 *  Disable view.
 */
fun View.disable() {
    if (this.isEnabled) {
        this.isEnabled = false
    }
}

/**
 *  Simplified version of [View.setOnClickListener].
 *
 *  @param block Callback to invoke after onClick is invoked.
 */
fun <T : View> T.click(block: (T) -> Unit) = this.setOnClickListener { block(it as T) }

/**
 *  Remove callback on [View.setOnClickListener].
 */
fun <T : View> T.noClick() = this.setOnClickListener(null)

/**
 *  Simplified version of [View.setOnLongClickListener].
 *
 *  @param block Callback to invoke after onLongClick is invoked.
 */
fun <T : View> T.longClick(block: (T) -> Boolean) = this.setOnLongClickListener { block(it as T) }

/**
 *  Remove callback on [View.setOnLongClickListener].
 */
fun <T : View> T.noLongClick() = this.setOnLongClickListener(null)

/**
 *  Set visibility to [View.VISIBLE] if match block.
 *
 *  @param block Callback to invoke when doing comparison.
 */
inline fun View.showIf(block: () -> Boolean) {
    if (block()) {
        this.visible()
    }
}

/**
 *  Set visibility to [View.VISIBLE] if match block, otherwise set visibility to [View.INVISIBLE].
 *
 *  @param block Callback to invoke when doing comparison.
 */
inline fun View.showIfElseHide(block: () -> Boolean) {
    if (block()) {
        this.visible()
    } else {
        this.invisible()
    }
}

/**
 *  Set visibility to [View.VISIBLE] if match block, otherwise set visibility to [View.GONE].
 *
 *  @param block Callback to invoke when doing comparison.
 */
inline fun View.showIfElseGone(block: () -> Boolean) {
    if (block()) {
        this.visible()
    } else {
        this.gone()
    }
}

/**
 *  Set visibility to [View.INVISIBLE] if match block.
 *
 *  @param block Callback to invoke when doing comparison.
 */
inline fun View.hideIf(block: () -> Boolean) {
    if (block()) {
        this.invisible()
    }
}

/**
 *  Set visibility to [View.INVISIBLE] if match block, otherwise set visibility to [View.VISIBLE].
 *
 *  @param block Callback to invoke when doing comparison.
 */
inline fun View.hideIfElseShow(block: () -> Boolean) {
    if (block()) {
        this.invisible()
    } else {
        this.visible()
    }
}

/**
 *  Set visibility to [View.GONE] if match block.
 *
 *  @param block Callback to invoke when doing comparison.
 */
inline fun View.goneIf(block: () -> Boolean) {
    if (block()) {
        this.gone()
    }
}

/**
 *  Set visibility to [View.GONE] if match block, otherwise set visibility to [View.VISIBLE].
 *
 *  @param block Callback to invoke when doing comparison.
 */
inline fun View.goneIfElseShow(block: () -> Boolean) {
    if (block()) {
        this.gone()
    } else {
        this.visible()
    }
}

/**
 *  Add hold up gesture to View.
 *
 *  @param onTouchDownAction Action to invoke when touch down.
 *  @param onLongPressReleaseAction Action to invoke when long press release.
 */
@SuppressLint("ClickableViewAccessibility")
fun View.touchHoldUp(
    onTouchDownAction: (() -> Unit)?,
    onLongPressReleaseAction: (() -> Unit)?
) {
    var isLongPressed = false

    val gestureDetector =
        GestureDetectorCompat(this.context, object : GestureDetector.SimpleOnGestureListener() {

            override fun onDown(e: MotionEvent?): Boolean {
                onTouchDownAction?.invoke()
                isLongPressed = false
                return true
            }

            override fun onLongPress(e: MotionEvent?) {
                isLongPressed = true
            }
        })

    this.setOnTouchListener { _, event ->
        if (event.action == MotionEvent.ACTION_UP && isLongPressed) {
            onLongPressReleaseAction?.invoke()
        }
        gestureDetector.onTouchEvent(event)
        true
    }
}

/**
 *  Set text size to uniform.
 *  Resize based on given space.
 */
fun TextView.setSizeTextTypeToUniform() {
    TextViewCompat.setAutoSizeTextTypeWithDefaults(
        this,
        TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM
    )
}

/**
 *  Set text size to normal.
 */
fun TextView.setSizeTextTypeToNone() {
    TextViewCompat.setAutoSizeTextTypeWithDefaults(
        this,
        TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE
    )
}

/**
 *  Clear text in [EditText].
 */
fun EditText.clear() {
    this.text.clear()
}