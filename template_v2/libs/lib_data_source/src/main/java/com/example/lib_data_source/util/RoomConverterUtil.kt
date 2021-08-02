package com.example.lib_data_source.util

object RoomConverterUtil {

    fun <T> doNullCheck(value: Any?, block: () -> T): T? {
        if (value == null) {
            return null
        }
        return block()
    }
}