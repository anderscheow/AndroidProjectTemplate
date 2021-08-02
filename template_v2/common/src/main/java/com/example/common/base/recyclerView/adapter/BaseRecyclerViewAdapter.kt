package com.example.common.base.recyclerView.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.common.base.recyclerView.viewHolder.BaseViewHolder

abstract class BaseRecyclerViewAdapter<T> : RecyclerView.Adapter<BaseViewHolder<*, *>>() {

    val items: MutableList<T> = mutableListOf()

    override fun getItemCount(): Int = items.size

    override fun onViewDetachedFromWindow(holder: BaseViewHolder<*, *>) {
        holder.onDetach()
    }

    fun set(itemsToAdd: List<T>) {
        items.clear()
        items.addAll(itemsToAdd)
        notifyDataSetChanged()
    }

    fun add(itemsToAdd: List<T>) {
        items.addAll(itemsToAdd)
        notifyDataSetChanged()
    }

    fun add(itemToAdd: T, position: Int) {
        items.add(position, itemToAdd)
        notifyItemInserted(position)
    }

    fun add(itemToAdd: T) {
        add(itemToAdd, items.size - 1)
    }

    fun remove(itemsToRemove: List<T>) {
        items.removeAll(itemsToRemove)
        notifyDataSetChanged()
    }

    fun remove(itemToRemove: T, position: Int) {
        items.remove(itemToRemove)
        notifyItemRemoved(position)
    }

    fun remove(itemToRemove: T) {
        remove(itemToRemove, items.indexOf(itemToRemove))
    }

    open fun update(itemToUpdate: T) {
        val index: Int = items.indexOf(itemToUpdate)
        if (index > -1) {
            notifyItemChanged(index)
        }
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }
}
