package com.example.common.base.fragment.bottom_sheet;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.example.common.viewmodel.BaseAndroidViewModel;
import com.example.common.viewmodel.util.AlertDialogData;
import com.example.common.viewmodel.util.AlertDialogMessageEvent;
import com.example.common.viewmodel.util.ProgressDialogMessageEvent;
import com.example.common.viewmodel.util.ToastMessageEvent;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0017R\u001b\u0010\u0007\u001a\u00028\u00008DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/example/common/base/fragment/bottom_sheet/LifecycleBottomSheetDialogFragment;", "VM", "Lcom/example/common/viewmodel/BaseAndroidViewModel;", "Lcom/example/common/base/fragment/bottom_sheet/FoundationBottomSheetDialogFragment;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "viewModel", "getViewModel", "()Lcom/example/common/viewmodel/BaseAndroidViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupAlertDialogEventObserver", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "setupProgressDialogEventObserver", "setupToastEventObserver", "setupViewModelObserver", "common_debug"})
public abstract class LifecycleBottomSheetDialogFragment<VM extends com.example.common.viewmodel.BaseAndroidViewModel<?>> extends com.example.common.base.fragment.bottom_sheet.FoundationBottomSheetDialogFragment {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public LifecycleBottomSheetDialogFragment(@org.jetbrains.annotations.NotNull()
    java.lang.Class<VM> clazz) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final VM getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Used to observe Observer in ViewModel.
     */
    @androidx.annotation.CallSuper()
    public void setupViewModelObserver(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner lifecycleOwner) {
    }
    
    /**
     * Setup and listen to progress dialog message event.
     */
    private final void setupProgressDialogEventObserver(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
    }
    
    /**
     * Setup and listen to toast message event.
     */
    private final void setupToastEventObserver(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
    }
    
    /**
     * Setup and listen to alert dialog message event.
     */
    private final void setupAlertDialogEventObserver(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
    }
}