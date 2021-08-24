package com.example.common.base.viewmodel.state

import com.example.lib_data_source.network.source.Error

interface BaseState

open class StateData<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    val error: Error? = null,
) : BaseState {

    companion object {
        fun <T> loading(isLoading: Boolean = true): StateData<T> = StateData(
            isLoading = isLoading
        )

        fun <T> data(data: T?): StateData<T> = StateData(
            isLoading = false,
            data = data
        )

        fun <T> error(error: Error): StateData<T> = StateData(
            isLoading = false,
            error = error
        )
    }
}