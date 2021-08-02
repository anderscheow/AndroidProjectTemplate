@file:Suppress("UNCHECKED_CAST")

package com.example.common.util.ext

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

/**
 *  Determine whether fragment is still there.
 *
 *  @return Boolean value.
 */
fun Fragment.isNotThere(): Boolean = (activity?.isFinishing ?: true) || isDetached

/**
 *  Invoke block if fragment is added.
 *
 *  @param block Callback to invoke if fragment is added.
 */
inline fun Fragment.isAdded(block: () -> Unit) {
    if (isAdded) block.invoke()
}

/**
 *  Invoke block if context is not null.
 *
 *  @param block Callback to invoke if fragment is not null.
 */
inline fun Fragment.withContext(block: (Context) -> Unit) = context?.let(block)

/**
 *  Invoke block with generic if context is not null.
 *
 *  @param block Callback to invoke if fragment is not null.
 */
inline fun <T> Fragment.withContextAs(block: (T) -> Unit) = (context as? T)?.let(block)

/**
 *  Cast context to desire class if context is not null.
 *
 *  @return Casted context.
 */
fun <T> Fragment.withContextAs(): T? = (context as? T)

/**
 *  Invoke block if activity is not null.
 *
 *  @param block Callback to invoke if fragment is not null.
 */
inline fun Fragment.withActivity(block: (Activity) -> Unit) = activity?.let(block)

/**
 *  Invoke block with generic if activity is not null.
 *
 *  @param block Callback to invoke if fragment is not null.
 */
inline fun <T> Fragment.withActivityAs(block: (T) -> Unit) = (activity as? T)?.let(block)

/**
 *  Cast activity to desire class if activity is not null.
 *
 *  @return Casted activity.
 */
fun <T> Fragment.withActivityAs(): T? = (activity as? T)

/**
 * Display the simple Toast message with the [Toast.LENGTH_SHORT] duration.
 *
 * @param message the message text resource.
 */
fun Fragment.toast(message: Int) = activity?.toast(message)

/**
 * Display the simple Toast message with the [Toast.LENGTH_SHORT] duration.
 *
 * @param message the message text.
 */
fun Fragment.toast(message: CharSequence) = activity?.toast(message)

/**
 * Display the simple Toast message with the [Toast.LENGTH_LONG] duration.
 *
 * @param message the message text.
 */
fun Fragment.longToast(message: Int) = activity?.longToast(message)

/**
 * Display the simple Toast message with the [Toast.LENGTH_LONG] duration.
 *
 * @param message the message text resource.
 */
fun Fragment.longToast(message: CharSequence) = activity?.longToast(message)

/**
 *  Show soft keyboard on focus view.
 *
 *  @param view Targeted view to let soft keyboard to focus on.
 */
fun Fragment.showKeyboard(view: View?) {
    activity?.showKeyboard(view)
}

/**
 *  Show soft keyboard on current activity's focus view.
 */
fun Fragment.showKeyboard() {
    activity?.showKeyboard()
}

/**
 *  Hide soft keyboard on focus view.
 *
 *  @param view Targeted view to let soft keyboard to remove focus.
 */
fun Fragment.hideKeyboard(view: View?) {
    activity?.hideKeyboard(view)
}

/**
 *  Hide soft keyboard on current activity's focus view.
 */
fun Fragment.hideKeyboard() {
    activity?.hideKeyboard()
}

/**
 *  To ensure fragment with same tag does not show multiple times.
 *
 *  @param tag Unique string, recommended to use class name.
 *  @param fragment Callback to return fragment that needed to show.
 */
fun Fragment.removeDialogFragmentThen(tag: String, fragment: () -> DialogFragment) {
    childFragmentManager.apply {
        (this.findFragmentByTag(tag) as? DialogFragment)?.dismissAllowingStateLoss()
        fragment().show(this, tag)
    }
}