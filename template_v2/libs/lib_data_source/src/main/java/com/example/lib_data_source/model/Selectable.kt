package com.example.lib_data_source.model

data class Selectable<T>(
    val data: T,
    var isSelected: Boolean = false
)
