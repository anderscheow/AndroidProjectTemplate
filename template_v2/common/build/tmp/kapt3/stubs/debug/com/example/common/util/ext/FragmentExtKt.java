package com.example.common.util.ext;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

@kotlin.Suppress(names = {"UNCHECKED_CAST"})
@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u001e\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0086\b\u00f8\u0001\u0000\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0002\u001a\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u00022\u0006\u0010\f\u001a\u00020\r\u001a\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u00022\u0006\u0010\f\u001a\u00020\u000e\u001a \u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u000b*\u00020\u00022\u0006\u0010\f\u001a\u00020\r\u001a\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u000b*\u00020\u00022\u0006\u0010\f\u001a\u00020\u000e\u001a+\u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u001a\u0017\u0010\u001a\u001a\u0004\u0018\u0001H\u001b\"\u0004\b\u0000\u0010\u001b*\u00020\u0002\u00a2\u0006\u0002\u0010\u001c\u001a1\u0010\u001a\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u001b*\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00010\u0017H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u001a+\u0010\u001d\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\u0017H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u001a\u0017\u0010\u001f\u001a\u0004\u0018\u0001H\u001b\"\u0004\b\u0000\u0010\u001b*\u00020\u0002\u00a2\u0006\u0002\u0010\u001c\u001a1\u0010\u001f\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u001b*\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00010\u0017H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006 "}, d2 = {"hideKeyboard", "", "Landroidx/fragment/app/Fragment;", "view", "Landroid/view/View;", "isAdded", "block", "Lkotlin/Function0;", "isNotThere", "", "longToast", "Landroid/widget/Toast;", "message", "", "", "removeDialogFragmentThen", "tag", "", "fragment", "Landroidx/fragment/app/DialogFragment;", "showKeyboard", "toast", "withActivity", "Lkotlin/Function1;", "Landroid/app/Activity;", "(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "withActivityAs", "T", "(Landroidx/fragment/app/Fragment;)Ljava/lang/Object;", "withContext", "Landroid/content/Context;", "withContextAs", "common_debug"})
public final class FragmentExtKt {
    
    /**
     * Determine whether fragment is still there.
     *
     * @return Boolean value.
     */
    public static final boolean isNotThere(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$isNotThere) {
        return false;
    }
    
    /**
     * Invoke block if fragment is added.
     *
     * @param block Callback to invoke if fragment is added.
     */
    public static final void isAdded(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$isAdded, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> block) {
    }
    
    /**
     * Invoke block if context is not null.
     *
     * @param block Callback to invoke if fragment is not null.
     */
    @org.jetbrains.annotations.Nullable()
    public static final kotlin.Unit withContext(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$withContext, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.content.Context, kotlin.Unit> block) {
        return null;
    }
    
    /**
     * Invoke block with generic if context is not null.
     *
     * @param block Callback to invoke if fragment is not null.
     */
    @org.jetbrains.annotations.Nullable()
    public static final <T extends java.lang.Object>kotlin.Unit withContextAs(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$withContextAs, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> block) {
        return null;
    }
    
    /**
     * Cast context to desire class if context is not null.
     *
     * @return Casted context.
     */
    @org.jetbrains.annotations.Nullable()
    public static final <T extends java.lang.Object>T withContextAs(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$withContextAs) {
        return null;
    }
    
    /**
     * Invoke block if activity is not null.
     *
     * @param block Callback to invoke if fragment is not null.
     */
    @org.jetbrains.annotations.Nullable()
    public static final kotlin.Unit withActivity(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$withActivity, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.app.Activity, kotlin.Unit> block) {
        return null;
    }
    
    /**
     * Invoke block with generic if activity is not null.
     *
     * @param block Callback to invoke if fragment is not null.
     */
    @org.jetbrains.annotations.Nullable()
    public static final <T extends java.lang.Object>kotlin.Unit withActivityAs(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$withActivityAs, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> block) {
        return null;
    }
    
    /**
     * Cast activity to desire class if activity is not null.
     *
     * @return Casted activity.
     */
    @org.jetbrains.annotations.Nullable()
    public static final <T extends java.lang.Object>T withActivityAs(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$withActivityAs) {
        return null;
    }
    
    /**
     * Display the simple Toast message with the [Toast.LENGTH_SHORT] duration.
     *
     * @param message the message text resource.
     */
    @org.jetbrains.annotations.Nullable()
    public static final android.widget.Toast toast(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$toast, int message) {
        return null;
    }
    
    /**
     * Display the simple Toast message with the [Toast.LENGTH_SHORT] duration.
     *
     * @param message the message text.
     */
    @org.jetbrains.annotations.Nullable()
    public static final android.widget.Toast toast(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$toast, @org.jetbrains.annotations.NotNull()
    java.lang.CharSequence message) {
        return null;
    }
    
    /**
     * Display the simple Toast message with the [Toast.LENGTH_LONG] duration.
     *
     * @param message the message text.
     */
    @org.jetbrains.annotations.Nullable()
    public static final android.widget.Toast longToast(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$longToast, int message) {
        return null;
    }
    
    /**
     * Display the simple Toast message with the [Toast.LENGTH_LONG] duration.
     *
     * @param message the message text resource.
     */
    @org.jetbrains.annotations.Nullable()
    public static final android.widget.Toast longToast(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$longToast, @org.jetbrains.annotations.NotNull()
    java.lang.CharSequence message) {
        return null;
    }
    
    /**
     * Show soft keyboard on focus view.
     *
     * @param view Targeted view to let soft keyboard to focus on.
     */
    public static final void showKeyboard(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$showKeyboard, @org.jetbrains.annotations.Nullable()
    android.view.View view) {
    }
    
    /**
     * Show soft keyboard on current activity's focus view.
     */
    public static final void showKeyboard(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$showKeyboard) {
    }
    
    /**
     * Hide soft keyboard on focus view.
     *
     * @param view Targeted view to let soft keyboard to remove focus.
     */
    public static final void hideKeyboard(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$hideKeyboard, @org.jetbrains.annotations.Nullable()
    android.view.View view) {
    }
    
    /**
     * Hide soft keyboard on current activity's focus view.
     */
    public static final void hideKeyboard(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$hideKeyboard) {
    }
    
    /**
     * To ensure fragment with same tag does not show multiple times.
     *
     * @param tag Unique string, recommended to use class name.
     * @param fragment Callback to return fragment that needed to show.
     */
    public static final void removeDialogFragmentThen(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$removeDialogFragmentThen, @org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends androidx.fragment.app.DialogFragment> fragment) {
    }
}