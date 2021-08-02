@file:Suppress("UNCHECKED_CAST")

package com.example.common.util.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 *  Retrieve property from intent.
 *
 *  @param key Key of the property.
 *
 *  @return Value of the property.
 */
fun <T : Any> FragmentActivity.argument(key: String) = lazy { intent?.extras?.get(key) as T? }

/**
 *  Retrieve property with default value from intent.
 *
 *  @param key Key of the property.
 *  @param defaultValue Return this value if key of the property from intent is null.
 *
 *  @return Value of the property or default value.
 */
fun <T : Any> FragmentActivity.argument(key: String, defaultValue: T) = lazy {
    intent?.extras?.get(key) as? T ?: defaultValue
}

/**
 *  Retrieve property from intent.
 *
 *  @param key Key of the property.
 *
 *  @return Value of the property.
 */
fun <T : Any> Fragment.argument(key: String) = lazy { arguments?.get(key) as T? }

/**
 *  Retrieve property with default value from intent.
 *
 *  @param key Key of the property.
 *  @param defaultValue Return this value if key of the property from intent is null.
 *
 *  @return Value of the property or default value.
 */
fun <T : Any> Fragment.argument(key: String, defaultValue: T) = lazy {
    arguments?.get(key) as? T ?: defaultValue
}
