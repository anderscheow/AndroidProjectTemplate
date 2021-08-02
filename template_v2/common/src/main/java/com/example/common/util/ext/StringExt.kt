package com.example.common.util.ext

/**
 *  Check whether String contain any of the given value in the list.
 *
 *  @param values List of string to check.
 *
 *  @return True if contain any, otherwise false.
 */
fun String.containsAny(values: List<String>): Boolean {
    values.forEach { value ->
        if (this.contains(value)) {
            return true
        }
    }

    return false
}

/**
 *  Check whether String contain all of the given value in the list.
 *
 *  @param values List of string to check.
 *
 *  @return True if contain all, otherwise false.
 */
fun String.containsAll(values: List<String>): Boolean {
    var isContain = true

    values.forEach { value ->
        if (this.contains(value).not()) {
            isContain = false
            return@forEach
        }
    }

    return isContain
}