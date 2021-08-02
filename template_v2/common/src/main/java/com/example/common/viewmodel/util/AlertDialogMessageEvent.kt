package com.example.common.viewmodel.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

data class AlertDialogData(
    val message: String,
    val action: (() -> Unit)? = null
)

class AlertDialogMessageEvent : SingleLiveEvent<AlertDialogData>() {

    /**
     *  Observe changes of AlertDialogData
     *
     *  @param owner LifecycleOwner
     *  @param observer AlertDialogObserver
     */
    fun observe(owner: LifecycleOwner, observer: AlertDialogObserver) {
        super.observe(owner, Observer { t ->
            if (t == null) {
                return@Observer
            }

            observer.onNewMessage(t)
        })
    }

    interface AlertDialogObserver {
        /**
         *  Called when there is a new message to be shown.
         *
         *  @param data The new message, non-null.
         */
        fun onNewMessage(data: AlertDialogData)
    }
}
