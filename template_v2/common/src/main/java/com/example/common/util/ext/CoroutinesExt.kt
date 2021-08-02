package com.example.common.util.ext

import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 *  Run async in [Dispatchers.IO].
 *
 *  @return Deferred function.
 */
fun <T> CoroutineScope.asyncIO(block: suspend CoroutineScope.() -> T) =
    async(Dispatchers.IO) { block() }

/**
 *  Convert [EditText.doOnTextChanged] into [StateFlow] to take advantages of Coroutine Flow.
 *
 *  @return [StateFlow] of CharSequence.
 */
fun EditText.textChanges(): StateFlow<CharSequence> {
    val query = MutableStateFlow<CharSequence>("")
    this.doOnTextChanged { text, _, _, _ ->
        query.value = text?.toString() ?: ""
    }
    return query
}