package com.example.common.base.recyclerView.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.example.common.base.recyclerView.viewHolder.BaseViewHolder;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u0002B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\fJ\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\u0014\u0010\t\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\u0006\u0010\u0012\u001a\u00020\nJ\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u000e\u0010\u0015\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0016J\u0013\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\fJ\u001b\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\u0014\u0010\u0016\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\u0014\u0010\u0019\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\u0015\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u001c"}, d2 = {"Lcom/example/common/base/recyclerView/adapter/BaseRecyclerViewAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/common/base/recyclerView/viewHolder/BaseViewHolder;", "()V", "items", "", "getItems", "()Ljava/util/List;", "add", "", "itemToAdd", "(Ljava/lang/Object;)V", "position", "", "(Ljava/lang/Object;I)V", "itemsToAdd", "", "clear", "getItemCount", "onViewDetachedFromWindow", "holder", "remove", "itemToRemove", "itemsToRemove", "set", "update", "itemToUpdate", "common_debug"})
public abstract class BaseRecyclerViewAdapter<T extends java.lang.Object> extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.common.base.recyclerView.viewHolder.BaseViewHolder<?, ?>> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<T> items = null;
    
    public BaseRecyclerViewAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<T> getItems() {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onViewDetachedFromWindow(@org.jetbrains.annotations.NotNull()
    com.example.common.base.recyclerView.viewHolder.BaseViewHolder<?, ?> holder) {
    }
    
    public final void set(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> itemsToAdd) {
    }
    
    public final void add(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> itemsToAdd) {
    }
    
    public final void add(T itemToAdd, int position) {
    }
    
    public final void add(T itemToAdd) {
    }
    
    public final void remove(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> itemsToRemove) {
    }
    
    public final void remove(T itemToRemove, int position) {
    }
    
    public final void remove(T itemToRemove) {
    }
    
    public void update(T itemToUpdate) {
    }
    
    public final void clear() {
    }
}