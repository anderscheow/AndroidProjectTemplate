package com.example.common.base.recyclerView.adapter.paging

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.example.common.base.recyclerView.viewHolder.NetworkStateViewHolder

class NetworkLoadStateAdapter(
    private val retryCallback: () -> Unit
) : LoadStateAdapter<NetworkStateViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): NetworkStateViewHolder {
        return NetworkStateViewHolder.create(parent, retryCallback)
    }

    override fun onBindViewHolder(holder: NetworkStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }
}