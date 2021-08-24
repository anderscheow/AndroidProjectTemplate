package com.example.common.base.viewmodel.state

import android.app.Application
import com.example.common.base.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class ViewModelWithState<in Args, State : BaseState>(
    application: Application,
    initialState: State
) : BaseViewModel<Args>(application) {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State>
        get() = _state.asStateFlow()

    /**
     *  Update value of mutable StateFlow.
     *
     *  @param block Pass in current value and return with updated or changed value.
     */
    protected fun updateState(block: State.() -> State) {
        _state.value = block(_state.value)
    }
}
