package com.example.common.util

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.base.recyclerView.adapter.paging.NetworkLoadStateAdapter

object PagingUtil {

    fun configureSpanSizeForLoader(
        gridLayoutManager: GridLayoutManager,
        adapter: RecyclerView.Adapter<*>,
        footerAdapter: NetworkLoadStateAdapter
    ) {
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position == adapter.itemCount && footerAdapter.itemCount > 0) {
                    gridLayoutManager.spanCount
                } else {
                    1
                }
            }
        }
    }
}