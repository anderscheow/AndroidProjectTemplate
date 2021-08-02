package com.example.common.util.ext;

import androidx.paging.CombinedLoadStates;
import androidx.paging.LoadState;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u00a8\u0006\u0005"}, d2 = {"getErrorState", "Landroidx/paging/LoadState$Error;", "Landroidx/paging/CombinedLoadStates;", "hasFinishRefresh", "", "common_debug"})
public final class CombinedLoadStatesExtKt {
    
    /**
     * Get [LoadState.Error] from [CombinedLoadStates].
     *
     * @return LoadState.Error.
     */
    @org.jetbrains.annotations.Nullable()
    public static final androidx.paging.LoadState.Error getErrorState(@org.jetbrains.annotations.NotNull()
    androidx.paging.CombinedLoadStates $this$getErrorState) {
        return null;
    }
    
    /**
     * Check whether mediator has finish refresh.
     *
     * @return Boolean, refresh status.
     */
    public static final boolean hasFinishRefresh(@org.jetbrains.annotations.NotNull()
    androidx.paging.CombinedLoadStates $this$hasFinishRefresh) {
        return false;
    }
}