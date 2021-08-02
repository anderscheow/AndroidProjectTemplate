package com.example.common.base.activity;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.lifecycle.ViewModelProvider;
import com.example.common.viewmodel.BaseAndroidViewModel;
import com.example.common.viewmodel.util.AlertDialogData;
import com.example.common.viewmodel.util.AlertDialogMessageEvent;
import com.example.common.viewmodel.util.ProgressDialogMessageEvent;
import com.example.common.viewmodel.util.ToastMessageEvent;

/**
 * Used for Lifecycle activity.
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0017R\u001b\u0010\u0007\u001a\u00028\u00008DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lcom/example/common/base/activity/LifecycleActivity;", "VM", "Lcom/example/common/viewmodel/BaseAndroidViewModel;", "Lcom/example/common/base/activity/FoundationActivity;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "viewModel", "getViewModel", "()Lcom/example/common/viewmodel/BaseAndroidViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupAlertDialogEventObserver", "setupProgressDialogEventObserver", "setupToastEventObserver", "setupViewModelObserver", "common_debug"})
public abstract class LifecycleActivity<VM extends com.example.common.viewmodel.BaseAndroidViewModel<?>> extends com.example.common.base.activity.FoundationActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public LifecycleActivity(@org.jetbrains.annotations.NotNull()
    java.lang.Class<VM> clazz) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final VM getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Used to observe Observer in ViewModel.
     */
    @androidx.annotation.CallSuper()
    public void setupViewModelObserver() {
    }
    
    /**
     * Setup and listen to progress dialog message event.
     */
    private final void setupProgressDialogEventObserver() {
    }
    
    /**
     * Setup and listen to toast message event.
     */
    private final void setupToastEventObserver() {
    }
    
    /**
     * Setup and listen to alert dialog message event.
     */
    private final void setupAlertDialogEventObserver() {
    }
}