package com.example.common.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.common.repository.auth_repository.IAuthRepository;
import com.example.common.repository.system_repository.ISystemRepository;
import com.example.common.viewmodel.util.AlertDialogData;
import com.example.common.viewmodel.util.AlertDialogMessageEvent;
import com.example.common.viewmodel.util.ProgressDialogMessageEvent;
import com.example.common.viewmodel.util.ToastMessageEvent;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010%\u001a\u00020&H\u0004J\b\u0010\'\u001a\u00020\u0012H\u0004J\b\u0010(\u001a\u00020\u0012H\u0004J\b\u0010)\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\u0012H\u0004J\u0010\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020.H\u0004J\u0012\u0010/\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u000100H\u0004J\u0010\u00101\u001a\u00020&2\u0006\u00102\u001a\u000200H\u0004J\u0019\u00103\u001a\u00020&2\n\b\u0002\u00104\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0002\u00105R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR)\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0010\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$\u00a8\u00066"}, d2 = {"Lcom/example/common/viewmodel/BaseAndroidViewModel;", "Args", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "alertDialogMessageEvent", "Lcom/example/common/viewmodel/util/AlertDialogMessageEvent;", "getAlertDialogMessageEvent", "()Lcom/example/common/viewmodel/util/AlertDialogMessageEvent;", "authRepository", "Lcom/example/common/repository/auth_repository/IAuthRepository;", "getAuthRepository", "()Lcom/example/common/repository/auth_repository/IAuthRepository;", "setAuthRepository", "(Lcom/example/common/repository/auth_repository/IAuthRepository;)V", "isLoading", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "()Landroidx/lifecycle/MutableLiveData;", "isLoading$delegate", "Lkotlin/Lazy;", "progressDialogMessageEvent", "Lcom/example/common/viewmodel/util/ProgressDialogMessageEvent;", "getProgressDialogMessageEvent", "()Lcom/example/common/viewmodel/util/ProgressDialogMessageEvent;", "systemRepository", "Lcom/example/common/repository/system_repository/ISystemRepository;", "getSystemRepository", "()Lcom/example/common/repository/system_repository/ISystemRepository;", "setSystemRepository", "(Lcom/example/common/repository/system_repository/ISystemRepository;)V", "toastMessageEvent", "Lcom/example/common/viewmodel/util/ToastMessageEvent;", "getToastMessageEvent", "()Lcom/example/common/viewmodel/util/ToastMessageEvent;", "dismissProgressDialog", "", "isGuest", "isLoggedIn", "onRefresh", "setIsLoading", "value", "showAlertDialog", "data", "Lcom/example/common/viewmodel/util/AlertDialogData;", "showProgressDialog", "", "showToast", "message", "start", "args", "(Ljava/lang/Object;)V", "common_debug"})
public abstract class BaseAndroidViewModel<Args extends java.lang.Object> extends androidx.lifecycle.AndroidViewModel {
    @javax.inject.Inject()
    public com.example.common.repository.system_repository.ISystemRepository systemRepository;
    @javax.inject.Inject()
    public com.example.common.repository.auth_repository.IAuthRepository authRepository;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy isLoading$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.common.viewmodel.util.ToastMessageEvent toastMessageEvent = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.common.viewmodel.util.ProgressDialogMessageEvent progressDialogMessageEvent = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.common.viewmodel.util.AlertDialogMessageEvent alertDialogMessageEvent = null;
    
    public BaseAndroidViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.common.repository.system_repository.ISystemRepository getSystemRepository() {
        return null;
    }
    
    public final void setSystemRepository(@org.jetbrains.annotations.NotNull()
    com.example.common.repository.system_repository.ISystemRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.common.repository.auth_repository.IAuthRepository getAuthRepository() {
        return null;
    }
    
    public final void setAuthRepository(@org.jetbrains.annotations.NotNull()
    com.example.common.repository.auth_repository.IAuthRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.common.viewmodel.util.ToastMessageEvent getToastMessageEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.common.viewmodel.util.ProgressDialogMessageEvent getProgressDialogMessageEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.common.viewmodel.util.AlertDialogMessageEvent getAlertDialogMessageEvent() {
        return null;
    }
    
    /**
     * Default entry point for ViewModel.
     *
     * @param args Generic type of this class
     */
    public abstract void start(@org.jetbrains.annotations.Nullable()
    Args args);
    
    /**
     * Action to do when refresh is triggered.
     *
     * Default same as start().
     */
    public void onRefresh() {
    }
    
    /**
     * Called to show or dismiss progress dialog.
     *
     * @param value If value is null, dialog dismiss, otherwise display.
     */
    protected final void showProgressDialog(@org.jetbrains.annotations.Nullable()
    java.lang.Object value) {
    }
    
    /**
     * Called to dismiss progress dialog
     */
    protected final void dismissProgressDialog() {
    }
    
    /**
     * Called to show toast.
     *
     * @param message Message to display in toast.
     */
    protected final void showToast(@org.jetbrains.annotations.NotNull()
    java.lang.Object message) {
    }
    
    /**
     * Called to show alert dialog.
     *
     * @param data Message to display in alert dialog.
     */
    protected final void showAlertDialog(@org.jetbrains.annotations.NotNull()
    com.example.common.viewmodel.util.AlertDialogData data) {
    }
    
    /**
     * Called to set loading.
     *
     * @param value Boolean to show or hide loading.
     */
    protected final void setIsLoading(boolean value) {
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
}