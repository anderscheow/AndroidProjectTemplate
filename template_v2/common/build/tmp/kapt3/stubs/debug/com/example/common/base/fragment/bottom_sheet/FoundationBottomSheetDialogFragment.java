package com.example.common.base.fragment.bottom_sheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.common.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0017J\b\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\bH&J\u0012\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/example/common/base/fragment/bottom_sheet/FoundationBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "getTheme", "", "getViewBinding", "Landroid/view/View;", "init", "", "savedInstanceState", "Landroid/os/Bundle;", "initListeners", "initViews", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "common_debug"})
public abstract class FoundationBottomSheetDialogFragment extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
    
    public FoundationBottomSheetDialogFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public int getTheme() {
        return 0;
    }
    
    /**
     * Setup and return the view from ViewBinding.
     *
     * @return View from ViewBinding.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract android.view.View getViewBinding();
    
    /**
     * To initialise views.
     */
    public abstract void initViews();
    
    /**
     * To initialise listeners.
     */
    public abstract void initListeners();
    
    /**
     * Call from {@link androidx.fragment.app.Fragment#onViewCreated} to reduce boilerplate.
     */
    @androidx.annotation.CallSuper()
    public void init(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
}