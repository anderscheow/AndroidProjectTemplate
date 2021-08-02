package com.example.common.base.recyclerView.adapter.paging;

import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import com.example.common.base.recyclerView.viewHolder.BaseViewHolder;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0016\u0012\u0004\u0012\u0002H\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u0003B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/example/common/base/recyclerView/adapter/paging/BasePagingDataAdapter;", "T", "", "Landroidx/paging/PagingDataAdapter;", "Lcom/example/common/base/recyclerView/viewHolder/BaseViewHolder;", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "onViewDetachedFromWindow", "", "holder", "common_debug"})
public abstract class BasePagingDataAdapter<T extends java.lang.Object> extends androidx.paging.PagingDataAdapter<T, com.example.common.base.recyclerView.viewHolder.BaseViewHolder<?, ?>> {
    
    public BasePagingDataAdapter(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.DiffUtil.ItemCallback<T> diffCallback) {
        super(null, null, null);
    }
    
    @java.lang.Override()
    public void onViewDetachedFromWindow(@org.jetbrains.annotations.NotNull()
    com.example.common.base.recyclerView.viewHolder.BaseViewHolder<?, ?> holder) {
    }
}