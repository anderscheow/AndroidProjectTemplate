package com.example.common.util.ext;

import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.recyclerview.widget.*;
import com.example.common.R;
import com.example.common.tools.SpacingDecoration;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0002\u001a\n\u0010\f\u001a\u00020\u000b*\u00020\u0002\u001a\u001c\u0010\r\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u001a\u001e\u0010\u0010\u001a\u00020\u000b*\u00020\u00022\b\b\u0003\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u001a\u001e\u0010\u0013\u001a\u00020\u000b*\u00020\u00022\b\b\u0001\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u001a(\u0010\u0016\u001a\u00020\u000b*\u00020\u00022\b\b\u0001\u0010\u0017\u001a\u00020\u00042\b\b\u0001\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u001a\u001e\u0010\u0019\u001a\u00020\u000b*\u00020\u00022\b\b\u0001\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u00a8\u0006\u001a"}, d2 = {"asGrid", "Landroidx/recyclerview/widget/GridLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView;", "spanCount", "", "reverseLayout", "", "asHorizontal", "Landroidx/recyclerview/widget/LinearLayoutManager;", "asVertical", "disableAnimator", "", "isFixedSize", "smoothSnapToPosition", "position", "snapMode", "withDivider", "drawableRes", "orientation", "withHorizontalSpacing", "spacing", "includeEdge", "withSpacing", "hSpacing", "vSpacing", "withVerticalSpacing", "common_debug"})
public final class RecyclerViewExtKt {
    
    /**
     * Configure RecyclerView using [LinearLayoutManager] as vertical.
     *
     * @param reverseLayout When set to true, layouts from end to start.
     *
     * @return LayoutManager to use.
     */
    @org.jetbrains.annotations.NotNull()
    public static final androidx.recyclerview.widget.LinearLayoutManager asVertical(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView $this$asVertical, boolean reverseLayout) {
        return null;
    }
    
    /**
     * Configure RecyclerView using [LinearLayoutManager] as horizontal.
     *
     * @param reverseLayout When set to true, layouts from end to start.
     *
     * @return LayoutManager to use.
     */
    @org.jetbrains.annotations.NotNull()
    public static final androidx.recyclerview.widget.LinearLayoutManager asHorizontal(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView $this$asHorizontal, boolean reverseLayout) {
        return null;
    }
    
    /**
     * Configure RecyclerView using [GridLayoutManager] as vertical.
     *
     * @param spanCount Number of column.
     * @param reverseLayout When set to true, layouts from end to start.
     *
     * @return LayoutManager to use.
     */
    @org.jetbrains.annotations.NotNull()
    public static final androidx.recyclerview.widget.GridLayoutManager asGrid(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView $this$asGrid, int spanCount, boolean reverseLayout) {
        return null;
    }
    
    /**
     * Add divider to RecyclerView.
     *
     * @param drawableRes Divider drawable.
     * @param orientation Either vertical or horizontal.
     */
    public static final void withDivider(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView $this$withDivider, @androidx.annotation.DrawableRes()
    int drawableRes, int orientation) {
    }
    
    /**
     * Add horizontal and vertical spacing to RecyclerView.
     *
     * @param hSpacing Horizontal spacing.
     * @param vSpacing Vertical spacing.
     * @param includeEdge Add spacing to edge.
     */
    public static final void withSpacing(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView $this$withSpacing, @androidx.annotation.DimenRes()
    int hSpacing, @androidx.annotation.DimenRes()
    int vSpacing, boolean includeEdge) {
    }
    
    /**
     * Add horizontal spacing to RecyclerView.
     *
     * @param spacing Horizontal spacing.
     * @param includeEdge Add spacing to edge.
     */
    public static final void withHorizontalSpacing(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView $this$withHorizontalSpacing, @androidx.annotation.DimenRes()
    int spacing, boolean includeEdge) {
    }
    
    /**
     * Add vertical spacing to RecyclerView.
     *
     * @param spacing Vertical spacing.
     * @param includeEdge Add spacing to edge.
     */
    public static final void withVerticalSpacing(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView $this$withVerticalSpacing, @androidx.annotation.DimenRes()
    int spacing, boolean includeEdge) {
    }
    
    /**
     * Set RecyclerView has fixed size.
     */
    public static final void isFixedSize(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView $this$isFixedSize) {
    }
    
    /**
     * Disable RecyclerView default animator.
     */
    public static final void disableAnimator(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView $this$disableAnimator) {
    }
    
    /**
     * Snap item to position.
     *
     * @param position Target position.
     * @param snapMode Snap mode.
     */
    public static final void smoothSnapToPosition(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView $this$smoothSnapToPosition, int position, int snapMode) {
    }
}