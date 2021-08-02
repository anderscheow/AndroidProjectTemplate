package com.example.common.util.ext;

import android.annotation.SuppressLint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.widget.TextViewCompat;

@kotlin.Suppress(names = {"UNCHECKED_CAST"})
@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a-\u0010\u0003\u001a\u00020\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005*\u0002H\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00010\u0007\u00a2\u0006\u0002\u0010\b\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0005\u001a\u001e\u0010\f\u001a\u00020\u0001*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086\b\u00f8\u0001\u0000\u001a\u001e\u0010\u000f\u001a\u00020\u0001*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086\b\u00f8\u0001\u0000\u001a\u001e\u0010\u0010\u001a\u00020\u0001*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086\b\u00f8\u0001\u0000\u001a\u001e\u0010\u0011\u001a\u00020\u0001*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086\b\u00f8\u0001\u0000\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0005\u001a-\u0010\u0013\u001a\u00020\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005*\u0002H\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u000e0\u0007\u00a2\u0006\u0002\u0010\b\u001a\u0019\u0010\u0014\u001a\u00020\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005*\u0002H\u0004\u00a2\u0006\u0002\u0010\u0015\u001a\u0019\u0010\u0016\u001a\u00020\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005*\u0002H\u0004\u00a2\u0006\u0002\u0010\u0015\u001a\n\u0010\u0017\u001a\u00020\u0001*\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u0001*\u00020\u0018\u001a\u001e\u0010\u001a\u001a\u00020\u0001*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086\b\u00f8\u0001\u0000\u001a\u001e\u0010\u001b\u001a\u00020\u0001*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086\b\u00f8\u0001\u0000\u001a\u001e\u0010\u001c\u001a\u00020\u0001*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086\b\u00f8\u0001\u0000\u001a,\u0010\u001d\u001a\u00020\u0001*\u00020\u00052\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH\u0007\u001a\n\u0010 \u001a\u00020\u0001*\u00020\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006!"}, d2 = {"clear", "", "Landroid/widget/EditText;", "click", "T", "Landroid/view/View;", "block", "Lkotlin/Function1;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "disable", "enable", "gone", "goneIf", "Lkotlin/Function0;", "", "goneIfElseShow", "hideIf", "hideIfElseShow", "invisible", "longClick", "noClick", "(Landroid/view/View;)V", "noLongClick", "setSizeTextTypeToNone", "Landroid/widget/TextView;", "setSizeTextTypeToUniform", "showIf", "showIfElseGone", "showIfElseHide", "touchHoldUp", "onTouchDownAction", "onLongPressReleaseAction", "visible", "common_debug"})
public final class ViewExtKt {
    
    /**
     * Set view's visibility to [View.GONE].
     */
    public static final void gone(@org.jetbrains.annotations.NotNull()
    android.view.View $this$gone) {
    }
    
    /**
     * Set view's visibility to [View.INVISIBLE].
     */
    public static final void invisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$invisible) {
    }
    
    /**
     * Set view's visibility to [View.VISIBLE].
     */
    public static final void visible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$visible) {
    }
    
    /**
     * Enable view.
     */
    public static final void enable(@org.jetbrains.annotations.NotNull()
    android.view.View $this$enable) {
    }
    
    /**
     * Disable view.
     */
    public static final void disable(@org.jetbrains.annotations.NotNull()
    android.view.View $this$disable) {
    }
    
    /**
     * Simplified version of [View.setOnClickListener].
     *
     * @param block Callback to invoke after onClick is invoked.
     */
    public static final <T extends android.view.View>void click(@org.jetbrains.annotations.NotNull()
    T $this$click, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> block) {
    }
    
    /**
     * Remove callback on [View.setOnClickListener].
     */
    public static final <T extends android.view.View>void noClick(@org.jetbrains.annotations.NotNull()
    T $this$noClick) {
    }
    
    /**
     * Simplified version of [View.setOnLongClickListener].
     *
     * @param block Callback to invoke after onLongClick is invoked.
     */
    public static final <T extends android.view.View>void longClick(@org.jetbrains.annotations.NotNull()
    T $this$longClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> block) {
    }
    
    /**
     * Remove callback on [View.setOnLongClickListener].
     */
    public static final <T extends android.view.View>void noLongClick(@org.jetbrains.annotations.NotNull()
    T $this$noLongClick) {
    }
    
    /**
     * Set visibility to [View.VISIBLE] if match block.
     *
     * @param block Callback to invoke when doing comparison.
     */
    public static final void showIf(@org.jetbrains.annotations.NotNull()
    android.view.View $this$showIf, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.Boolean> block) {
    }
    
    /**
     * Set visibility to [View.VISIBLE] if match block, otherwise set visibility to [View.INVISIBLE].
     *
     * @param block Callback to invoke when doing comparison.
     */
    public static final void showIfElseHide(@org.jetbrains.annotations.NotNull()
    android.view.View $this$showIfElseHide, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.Boolean> block) {
    }
    
    /**
     * Set visibility to [View.VISIBLE] if match block, otherwise set visibility to [View.GONE].
     *
     * @param block Callback to invoke when doing comparison.
     */
    public static final void showIfElseGone(@org.jetbrains.annotations.NotNull()
    android.view.View $this$showIfElseGone, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.Boolean> block) {
    }
    
    /**
     * Set visibility to [View.INVISIBLE] if match block.
     *
     * @param block Callback to invoke when doing comparison.
     */
    public static final void hideIf(@org.jetbrains.annotations.NotNull()
    android.view.View $this$hideIf, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.Boolean> block) {
    }
    
    /**
     * Set visibility to [View.INVISIBLE] if match block, otherwise set visibility to [View.VISIBLE].
     *
     * @param block Callback to invoke when doing comparison.
     */
    public static final void hideIfElseShow(@org.jetbrains.annotations.NotNull()
    android.view.View $this$hideIfElseShow, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.Boolean> block) {
    }
    
    /**
     * Set visibility to [View.GONE] if match block.
     *
     * @param block Callback to invoke when doing comparison.
     */
    public static final void goneIf(@org.jetbrains.annotations.NotNull()
    android.view.View $this$goneIf, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.Boolean> block) {
    }
    
    /**
     * Set visibility to [View.GONE] if match block, otherwise set visibility to [View.VISIBLE].
     *
     * @param block Callback to invoke when doing comparison.
     */
    public static final void goneIfElseShow(@org.jetbrains.annotations.NotNull()
    android.view.View $this$goneIfElseShow, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.Boolean> block) {
    }
    
    /**
     * Add hold up gesture to View.
     *
     * @param onTouchDownAction Action to invoke when touch down.
     * @param onLongPressReleaseAction Action to invoke when long press release.
     */
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    public static final void touchHoldUp(@org.jetbrains.annotations.NotNull()
    android.view.View $this$touchHoldUp, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> onTouchDownAction, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLongPressReleaseAction) {
    }
    
    /**
     * Set text size to uniform.
     * Resize based on given space.
     */
    public static final void setSizeTextTypeToUniform(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $this$setSizeTextTypeToUniform) {
    }
    
    /**
     * Set text size to normal.
     */
    public static final void setSizeTextTypeToNone(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $this$setSizeTextTypeToNone) {
    }
    
    /**
     * Clear text in [EditText].
     */
    public static final void clear(@org.jetbrains.annotations.NotNull()
    android.widget.EditText $this$clear) {
    }
}