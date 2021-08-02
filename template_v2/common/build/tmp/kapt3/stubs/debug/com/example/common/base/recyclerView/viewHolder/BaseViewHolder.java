package com.example.common.base.recyclerView.viewHolder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\rJ\u001d\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u000bH\u0016R\u0013\u0010\u0005\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/example/common/base/recyclerView/viewHolder/BaseViewHolder;", "T", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "(Landroidx/viewbinding/ViewBinding;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "Landroidx/viewbinding/ViewBinding;", "bind", "", "item", "(Ljava/lang/Object;)V", "extraBinding", "onClick", "view", "Landroid/view/View;", "(Landroid/view/View;Ljava/lang/Object;)V", "onDetach", "common_debug"})
public abstract class BaseViewHolder<T extends java.lang.Object, VB extends androidx.viewbinding.ViewBinding> extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    @org.jetbrains.annotations.NotNull()
    private final VB binding = null;
    
    public BaseViewHolder(@org.jetbrains.annotations.NotNull()
    VB binding) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final VB getBinding() {
        return null;
    }
    
    protected abstract void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View view, T item);
    
    protected abstract void extraBinding(T item);
    
    public void onDetach() {
    }
    
    public final void bind(T item) {
    }
}