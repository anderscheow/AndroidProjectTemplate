package com.example.common.viewmodel.util;

import androidx.annotation.StringRes;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\u000b"}, d2 = {"Lcom/example/common/viewmodel/util/ProgressDialogMessageEvent;", "Lcom/example/common/viewmodel/util/SingleLiveEvent;", "", "()V", "observe", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Lcom/example/common/viewmodel/util/ProgressDialogMessageEvent$ProgressDialogObserver;", "ProgressDialogObserver", "common_debug"})
public final class ProgressDialogMessageEvent extends com.example.common.viewmodel.util.SingleLiveEvent<java.lang.Object> {
    
    public ProgressDialogMessageEvent() {
        super();
    }
    
    /**
     * Observe changes of AlertDialogData
     *
     * @param owner LifecycleOwner
     * @param observer ProgressDialogObserver
     */
    public final void observe(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull()
    com.example.common.viewmodel.util.ProgressDialogMessageEvent.ProgressDialogObserver observer) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/common/viewmodel/util/ProgressDialogMessageEvent$ProgressDialogObserver;", "", "dismiss", "", "onNewMessage", "message", "", "", "common_debug"})
    public static abstract interface ProgressDialogObserver {
        
        /**
         * Called when there is a new message to be shown.
         *
         * @param message The new message, non-null.
         */
        public abstract void onNewMessage(@androidx.annotation.StringRes()
        int message);
        
        /**
         * Called when there is a new message to be shown.
         *
         * @param message The new message, non-null.
         */
        public abstract void onNewMessage(@org.jetbrains.annotations.NotNull()
        java.lang.String message);
        
        /**
         * Called when dismiss is required.
         */
        public abstract void dismiss();
    }
}