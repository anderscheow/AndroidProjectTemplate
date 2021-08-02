package com.example.lib_data_source.util

/**
 *  If-else comparison, return `value` if true, otherwise return null.
 *
 *  @param value Value to return if true.
 */
infix fun <T> Boolean.then(value: T?) = if (this) value else null

/**
 *  If-else comparison, do `function` if true, otherwise do `default`.
 *
 *  @param function Callback to call if true.
 *  @param default Callback to call if false.
 */
inline fun <T> Boolean.then(function: () -> T, default: () -> T) = if (this) function() else default()

/**
 *  If-else comparison, do `function` if true, otherwise return null.
 *
 *  @param function Callback to call if true.
 */
inline infix fun <reified T> Boolean.then(function: () -> T) = if (this) function() else null