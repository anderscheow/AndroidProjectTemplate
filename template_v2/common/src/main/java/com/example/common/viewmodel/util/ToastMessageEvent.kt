package com.example.common.viewmodel.util

import androidx.annotation.StringRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

class ToastMessageEvent : SingleLiveEvent<Any>() {

    /**
     *  Observe changes of AlertDialogData
     *
     *  @param owner LifecycleOwner
     *  @param observer ToastObserver
     */
    fun observe(owner: LifecycleOwner, observer: ToastObserver) {
        super.observe(owner, Observer { s ->
            if (s == null) {
                return@Observer
            }

            when (s) {
                is String -> observer.onNewMessage(s)

                is Int -> observer.onNewMessage(s)
            }
        })
    }

    interface ToastObserver {
        /**
         * Called when there is a new message to be shown.
         *
         * @param message The new message.
         */
        fun onNewMessage(message: String)

        /**
         * Called when there is a new message to be shown.
         *
         * @param message The new message.
         */
        fun onNewMessage(@StringRes message: Int)
    }
}
