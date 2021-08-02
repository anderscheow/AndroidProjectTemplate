package com.example.common.util.ext;

import android.widget.EditText;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlow;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\u001aG\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u00a2\u0006\u0002\b\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u001a\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\u00020\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"asyncIO", "Lkotlinx/coroutines/Deferred;", "T", "Lkotlinx/coroutines/CoroutineScope;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "textChanges", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroid/widget/EditText;", "common_debug"})
public final class CoroutinesExtKt {
    
    /**
     * Run async in [Dispatchers.IO].
     *
     * @return Deferred function.
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>kotlinx.coroutines.Deferred<T> asyncIO(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope $this$asyncIO, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> block) {
        return null;
    }
    
    /**
     * Convert [EditText.doOnTextChanged] into [StateFlow] to take advantages of Coroutine Flow.
     *
     * @return [StateFlow] of CharSequence.
     */
    @org.jetbrains.annotations.NotNull()
    public static final kotlinx.coroutines.flow.StateFlow<java.lang.CharSequence> textChanges(@org.jetbrains.annotations.NotNull()
    android.widget.EditText $this$textChanges) {
        return null;
    }
}