package com.example.common.util.ext;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0002\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\n\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0001\u001a \u0010\u000b\u001a\u00020\b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u001a\n\u0010\u0012\u001a\u00020\b*\u00020\u0002\u001a\u0014\u0010\u0012\u001a\u00020\b*\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\u0013\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0001\"\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0014"}, d2 = {"contentView", "Landroid/view/View;", "Landroid/app/Activity;", "getContentView", "(Landroid/app/Activity;)Landroid/view/View;", "getStatusBarHeight", "", "hideKeyboard", "", "view", "hideSystemUI", "removeDialogFragmentThen", "Landroidx/fragment/app/FragmentActivity;", "tag", "", "fragment", "Lkotlin/Function0;", "Landroidx/fragment/app/DialogFragment;", "showKeyboard", "showSystemUI", "common_debug"})
public final class ActivityExtKt {
    
    @org.jetbrains.annotations.Nullable()
    public static final android.view.View getContentView(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$contentView) {
        return null;
    }
    
    /**
     * Get status bar height.
     *
     * @return Height of status bar, return 0 if not supported.
     */
    public static final int getStatusBarHeight(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$getStatusBarHeight) {
        return 0;
    }
    
    /**
     * Show soft keyboard on focus view.
     *
     * @param view Targeted view to let soft keyboard to focus on.
     */
    public static final void showKeyboard(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$showKeyboard, @org.jetbrains.annotations.Nullable()
    android.view.View view) {
    }
    
    /**
     * Show soft keyboard on current activity's focus view.
     */
    public static final void showKeyboard(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$showKeyboard) {
    }
    
    /**
     * Hide soft keyboard on focus view.
     *
     * @param view Targeted view to let soft keyboard to remove focus.
     */
    public static final void hideKeyboard(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$hideKeyboard, @org.jetbrains.annotations.Nullable()
    android.view.View view) {
    }
    
    /**
     * Hide soft keyboard on current activity's focus view.
     */
    public static final void hideKeyboard(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$hideKeyboard) {
    }
    
    /**
     * Hide system UI.
     */
    public static final void hideSystemUI(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$hideSystemUI, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    /**
     * Show system UI.
     */
    public static final void showSystemUI(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$showSystemUI, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    /**
     * To ensure fragment with same tag does not show multiple times.
     *
     * @param tag Unique string, recommended to use class name.
     * @param fragment Callback to return fragment that needed to show.
     */
    public static final void removeDialogFragmentThen(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity $this$removeDialogFragmentThen, @org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends androidx.fragment.app.DialogFragment> fragment) {
    }
}