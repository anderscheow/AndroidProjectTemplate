package com.example.common.base.recyclerView.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.common.util.ext.click

abstract class BaseViewHolder<in T, VB : ViewBinding>(
    val binding: VB
) : RecyclerView.ViewHolder(binding.root) {

    protected abstract fun onClick(view: View, item: T)

    protected abstract fun extraBinding(item: T)

    open fun onDetach() {
    }

    fun bind(item: T) {
        binding.root.click { view ->
            onClick(view, item)
        }

        extraBinding(item)
    }
}
