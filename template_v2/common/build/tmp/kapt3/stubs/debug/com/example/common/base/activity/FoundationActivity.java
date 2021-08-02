package com.example.common.base.activity;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.common.constant.EventBusType;
import com.example.common.repository.auth_repository.IAuthRepository;
import com.orhanobut.logger.Logger;
import org.greenrobot.eventbus.EventBus;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH&J\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H&J\b\u0010\u0015\u001a\u00020\u0010H&J\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u000eJ\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0019\u001a\u00020\u0010H\u0014J\b\u0010\u001a\u001a\u00020\u0010H\u0014J\b\u0010\u001b\u001a\u00020\u0010H\u0014J\b\u0010\u001c\u001a\u00020\u0010H\u0014J\b\u0010\u001d\u001a\u00020\u0010H\u0014J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006 "}, d2 = {"Lcom/example/common/base/activity/FoundationActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "authRepository", "Lcom/example/common/repository/auth_repository/IAuthRepository;", "getAuthRepository", "()Lcom/example/common/repository/auth_repository/IAuthRepository;", "setAuthRepository", "(Lcom/example/common/repository/auth_repository/IAuthRepository;)V", "getEventBusType", "Lcom/example/common/constant/EventBusType;", "getViewBinding", "Landroid/view/View;", "handleGuestControl", "", "init", "", "savedInstanceState", "Landroid/os/Bundle;", "initActivityResultLauncher", "initListeners", "initViews", "isGuest", "isLoggedIn", "onCreate", "onDestroy", "onPause", "onResume", "onStart", "onStop", "registerEventBus", "unregisterEventBus", "common_debug"})
public abstract class FoundationActivity extends androidx.appcompat.app.AppCompatActivity {
    @javax.inject.Inject()
    public com.example.common.repository.auth_repository.IAuthRepository authRepository;
    
    public FoundationActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.common.repository.auth_repository.IAuthRepository getAuthRepository() {
        return null;
    }
    
    public final void setAuthRepository(@org.jetbrains.annotations.NotNull()
    com.example.common.repository.auth_repository.IAuthRepository p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
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
     * Call from {@link androidx.appcompat.app.AppCompatActivity#onCreate} to reduce boilerplate.
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
    public final boolean isLoggedIn() {
        return false;
    }
    
    /**
     * Check is guest mode.
     *
     * @return Boolean, guest mode status.
     */
    public final boolean isGuest() {
        return false;
    }
    
    /**
     * Navigate to login page if is under guest mode
     *
     * @return Boolean, guest mode status.
     */
    public final boolean handleGuestControl() {
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