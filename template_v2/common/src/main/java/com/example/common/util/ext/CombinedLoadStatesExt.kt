package com.example.common.util.ext

import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState

/**
 *  Get [LoadState.Error] from [CombinedLoadStates].
 *
 *  @return LoadState.Error.
 */
fun CombinedLoadStates.getErrorState(): LoadState.Error? {
    return this.mediator?.refresh as? LoadState.Error
        ?: this.source.append as? LoadState.Error
        ?: this.source.prepend as? LoadState.Error
        ?: this.append as? LoadState.Error
        ?: this.prepend as? LoadState.Error
}

/**
 *  Check whether mediator has finish refresh.
 *
 *  @return Boolean, refresh status.
 */
fun CombinedLoadStates.hasFinishRefresh(): Boolean {
    return this.mediator?.refresh is LoadState.NotLoading ||
            this.mediator?.refresh is LoadState.Error
}