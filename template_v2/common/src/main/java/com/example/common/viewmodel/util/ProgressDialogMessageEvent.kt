package com.example.common.viewmodel.util

import androidx.annotation.StringRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

class ProgressDialogMessageEvent : SingleLiveEvent<Any?>() {

    /**
     *  Observe changes of AlertDialogData
     *
     *  @param owner LifecycleOwner
     *  @param observer ProgressDialogObserver
     */
    fun observe(owner: LifecycleOwner, observer: ProgressDialogObserver) {
        super.observe(owner, Observer { t ->
            if (t == null) {
                observer.dismiss()
                return@Observer
            }

            when (t) {
                is String -> observer.onNewMessage(t)

                is Int -> observer.onNewMessage(t)

                else -> observer.dismiss()
            }
        })
    }

    interface ProgressDialogObserver {
        /**
         * Called when there is a new message to be shown.
         *
         * @param message The new message, non-null.
         */
        fun onNewMessage(@StringRes message: Int)

        /**
         * Called when there is a new message to be shown.
         *
         * @param message The new message, non-null.
         */
        fun onNewMessage(message: String)

        /**
         * Called when dismiss is required.
         */
        fun dismiss()
    }
}
