package com.example.common.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.common.base.activity.FoundationActivity;
import com.example.common.constant.EventBusType;
import com.orhanobut.logger.Logger;
import org.greenrobot.eventbus.EventBus;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0017J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH&J\b\u0010\u000f\u001a\u00020\nH&J\b\u0010\u0010\u001a\u00020\bH\u0004J\b\u0010\u0011\u001a\u00020\bH\u0004J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\b\u0010 \u001a\u00020\nH\u0016J\b\u0010!\u001a\u00020\nH\u0016J\u001a\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\nH\u0002\u00a8\u0006&"}, d2 = {"Lcom/example/common/base/fragment/FoundationFragment;", "Landroidx/fragment/app/Fragment;", "()V", "getEventBusType", "Lcom/example/common/constant/EventBusType;", "getViewBinding", "Landroid/view/View;", "handleGuestControl", "", "init", "", "savedInstanceState", "Landroid/os/Bundle;", "initActivityResultLauncher", "initListeners", "initViews", "isGuest", "isLoggedIn", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onDetach", "onPause", "onResume", "onStart", "onStop", "onViewCreated", "view", "registerEventBus", "unregisterEventBus", "common_debug"})
public abstract class FoundationFragment extends androidx.fragment.app.Fragment {
    
    public FoundationFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @java.lang.Override()
    public void onDetach() {
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
    
    /**
     * To initialise activity result launcher.
     */
    public void initActivityResultLauncher() {
    }
    
    /**
     * Used to establish EventBus in target lifecycle.
     *
     * @return EventBusType, or null if does not needed.
     */
    @org.jetbrains.annotations.Nullable()
    public com.example.common.constant.EventBusType getEventBusType() {
        return null;
    }
    
    /**
     * Check is logged in with user.
     *
     * @return Boolean, logged in status.
     */
    protected final boolean isLoggedIn() {
        return false;
    }
    
    /**
     * Check is guest mode.
     *
     * @return Boolean, guest mode status.
     */
    protected final boolean isGuest() {
        return false;
    }
    
    /**
     * Navigate to login page if is under guest mode
     *
     * @return Boolean, guest mode status.
     */
    protected final boolean handleGuestControl() {
        return false;
    }
    
    /**
     * Register EventBus if not registered.
     */
    private final void registerEventBus() {
    }
    
    /**
     * Unregister EventBus if registered.
     */
    private final void unregisterEventBus() {
    }
}