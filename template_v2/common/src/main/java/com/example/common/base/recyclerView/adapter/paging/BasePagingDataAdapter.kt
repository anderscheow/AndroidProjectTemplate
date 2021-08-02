package com.example.common.base.recyclerView.adapter.paging

import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.common.base.recyclerView.viewHolder.BaseViewHolder

abstract class BasePagingDataAdapter<T : Any>(
    diffCallback: DiffUtil.ItemCallback<T>,
) : PagingDataAdapter<T, BaseViewHolder<*, *>>(diffCallback) {

    override fun onViewDetachedFromWindow(holder: BaseViewHolder<*, *>) {
        holder.onDetach()
    }
}