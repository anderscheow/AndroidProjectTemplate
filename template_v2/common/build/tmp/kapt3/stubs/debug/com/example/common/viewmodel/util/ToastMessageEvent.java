package com.example.common.viewmodel.util;

import androidx.annotation.StringRes;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\u000b"}, d2 = {"Lcom/example/common/viewmodel/util/ToastMessageEvent;", "Lcom/example/common/viewmodel/util/SingleLiveEvent;", "", "()V", "observe", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Lcom/example/common/viewmodel/util/ToastMessageEvent$ToastObserver;", "ToastObserver", "common_debug"})
public final class ToastMessageEvent extends com.example.common.viewmodel.util.SingleLiveEvent<java.lang.Object> {
    
    public ToastMessageEvent() {
        super();
    }
    
    /**
     * Observe changes of AlertDialogData
     *
     * @param owner LifecycleOwner
     * @param observer ToastObserver
     */
    public final void observe(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull()
    com.example.common.viewmodel.util.ToastMessageEvent.ToastObserver observer) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/common/viewmodel/util/ToastMessageEvent$ToastObserver;", "", "onNewMessage", "", "message", "", "", "common_debug"})
    public static abstract interface ToastObserver {
        
        /**
         * Called when there is a new message to be shown.
         *
         * @param message The new message.
         */
        public abstract void onNewMessage(@org.jetbrains.annotations.NotNull()
        java.lang.String message);
        
        /**
         * Called when there is a new message to be shown.
         *
         * @param message The new message.
         */
        public abstract void onNewMessage(@androidx.annotation.StringRes()
        int message);
    }
}