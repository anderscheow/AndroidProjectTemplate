package com.example.common.util.ext

import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity

/**
 * Returns the content view of this Activity if set, null otherwise.
 */
inline val Activity.contentView: View?
    get() = this.findViewById<ViewGroup>(android.R.id.content)?.getChildAt(0)

/**
 *  Get status bar height.
 *
 *  @return Height of status bar, return 0 if not supported.
 */
fun Activity.getStatusBarHeight(): Int {
    var result = 0
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        val resourceId = resources.getIdentifier(
            "status_bar_height",
            "dimen",
            "android"
        )
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
    }
    return result
}

/**
 *  Show soft keyboard on focus view.
 *
 *  @param view Targeted view to let soft keyboard to focus on.
 */
fun Activity.showKeyboard(view: View?) {
    view?.let {
        it.requestFocus()

        (this.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.showSoftInput(
            it,
            InputMethodManager.SHOW_IMPLICIT
        )
    }
}

/**
 *  Show soft keyboard on current activity's focus view.
 */
fun Activity.showKeyboard() {
    showKeyboard(currentFocus)
}

/**
 *  Hide soft keyboard on focus view.
 *
 *  @param view Targeted view to let soft keyboard to remove focus.
 */
fun Activity.hideKeyboard(view: View?) {
    view?.let {
        (this.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.hideSoftInputFromWindow(
            it.windowToken,
            0
        )
    }
}

/**
 *  Hide soft keyboard on current activity's focus view.
 */
fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus)
}

/**
 *  Hide system UI.
 */
fun Activity.hideSystemUI(view: View) {
    WindowCompat.setDecorFitsSystemWindows(this.window, false)
    WindowInsetsControllerCompat(this.window, view).let { controller ->
        controller.hide(WindowInsetsCompat.Type.statusBars() or WindowInsetsCompat.Type.navigationBars())
        controller.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }
}

/**
 *  Show system UI.
 */
fun Activity.showSystemUI(view: View) {
    WindowCompat.setDecorFitsSystemWindows(window, true)
    WindowInsetsControllerCompat(window, view)
        .show(WindowInsetsCompat.Type.statusBars() or WindowInsetsCompat.Type.navigationBars())
}

/**
 *  To ensure fragment with same tag does not show multiple times.
 *
 *  @param tag Unique string, recommended to use class name.
 *  @param fragment Callback to return fragment that needed to show.
 */
fun FragmentActivity.removeDialogFragmentThen(tag: String, fragment: () -> DialogFragment) {
    supportFragmentManager.apply {
        (this.findFragmentByTag(tag) as? DialogFragment)?.dismissAllowingStateLoss()
        fragment().show(this, tag)
    }
}