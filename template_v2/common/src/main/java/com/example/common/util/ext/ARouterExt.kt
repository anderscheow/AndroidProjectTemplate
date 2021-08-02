package com.example.common.util.ext

import android.app.Activity
import android.os.Bundle
import android.os.Parcelable
import com.alibaba.android.arouter.launcher.ARouter

/**
 *  Navigate to specific path.
 *
 *  @param path Path to navigate.
 */
fun ARouter.navigateTo(path: String): Any? =
    build(path).navigation()

/**
 *  Navigate to specific path with request code. Similar to calling startActivityForResult.
 *
 *  @param activity Activity and so on.
 *  @param path Path to navigate.
 *  @param requestCode Request code to trigger startActivityForResult.
 */
fun ARouter.navigateTo(activity: Activity, path: String, requestCode: Int) {
    build(path).navigation(activity, requestCode)
}

/**
 *  Navigate to specific path with param.
 *
 *  @param path Path to navigate.
 *  @param key Key of the param.
 *  @param param Value of the param.
 */
fun ARouter.navigateToWithParam(path: String, key: String, param: Parcelable): Any? =
    build(path)
        .withParcelable(key, param)
        .navigation()

/**
 *  Navigate to specific path with param.
 *
 *  @param activity Activity and so on.
 *  @param path Path to navigate.
 *  @param key Key of the param.
 *  @param param Value of the param.
 *  @param requestCode Request code to trigger startActivityForResult.
 */
fun ARouter.navigateToWithParam(
    activity: Activity,
    path: String,
    key: String,
    param: Parcelable,
    requestCode: Int
) {
    build(path)
        .withParcelable(key, param)
        .navigation(activity, requestCode)
}

/**
 *  Navigate to specific path with param.
 *
 *  @param activity Activity and so on.
 *  @param path Path to navigate.
 *  @param bundle Default bundle.
 *  @param key Key of the param.
 *  @param param Value of the param.
 *  @param requestCode Request code to trigger startActivityForResult.
 */
fun ARouter.navigateToWithParam(
    activity: Activity,
    path: String,
    bundle: Bundle?,
    key: String,
    param: Parcelable,
    requestCode: Int
) {
    build(path)
        .with(bundle)
        .withParcelable(key, param)
        .navigation(activity, requestCode)
}