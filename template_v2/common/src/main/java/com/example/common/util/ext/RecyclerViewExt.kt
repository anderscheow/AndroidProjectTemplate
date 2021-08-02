package com.example.common.util.ext

import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.*
import com.example.common.R
import com.example.common.tools.SpacingDecoration

/**
 *  Configure RecyclerView using [LinearLayoutManager] as vertical.
 *
 *  @param reverseLayout When set to true, layouts from end to start.
 *
 *  @return LayoutManager to use.
 */
fun RecyclerView.asVertical(reverseLayout: Boolean = false): LinearLayoutManager {
    val linearLayoutManager = LinearLayoutManager(
        this.context,
        RecyclerView.VERTICAL,
        reverseLayout
    )
    this.layoutManager = linearLayoutManager

    return linearLayoutManager
}

/**
 *  Configure RecyclerView using [LinearLayoutManager] as horizontal.
 *
 *  @param reverseLayout When set to true, layouts from end to start.
 *
 *  @return LayoutManager to use.
 */
fun RecyclerView.asHorizontal(reverseLayout: Boolean = false): LinearLayoutManager {
    val linearLayoutManager = LinearLayoutManager(
        this.context,
        RecyclerView.HORIZONTAL,
        reverseLayout
    )
    this.layoutManager = linearLayoutManager

    return linearLayoutManager
}

/**
 *  Configure RecyclerView using [GridLayoutManager] as vertical.
 *
 *  @param spanCount Number of column.
 *  @param reverseLayout When set to true, layouts from end to start.
 *
 *  @return LayoutManager to use.
 */
fun RecyclerView.asGrid(
    spanCount: Int,
    reverseLayout: Boolean = false
): GridLayoutManager {
    val gridLayoutManager = GridLayoutManager(
        this.context,
        spanCount,
        RecyclerView.VERTICAL,
        reverseLayout
    )
    this.layoutManager = gridLayoutManager

    return gridLayoutManager
}

/**
 *  Add divider to RecyclerView.
 *
 *  @param drawableRes Divider drawable.
 *  @param orientation Either vertical or horizontal.
 */
fun RecyclerView.withDivider(
    @DrawableRes drawableRes: Int = R.drawable.bg_rec_width_0_height_5_solid_f9f9f9,
    orientation: Int = RecyclerView.VERTICAL
) {
    this.addItemDecoration(
        DividerItemDecoration(this.context, orientation).apply {
            this.setDrawable(this@withDivider.context.findDrawable(drawableRes)!!)
        }
    )
}

/**
 *  Add horizontal and vertical spacing to RecyclerView.
 *
 *  @param hSpacing Horizontal spacing.
 *  @param vSpacing Vertical spacing.
 *  @param includeEdge Add spacing to edge.
 */
fun RecyclerView.withSpacing(
    @DimenRes hSpacing: Int,
    @DimenRes vSpacing: Int,
    includeEdge: Boolean = true
) {
    this.addItemDecoration(
        SpacingDecoration(
            hSpacing = if (hSpacing == -1) 0 else this.resources.getDimensionPixelOffset(hSpacing),
            vSpacing = if (vSpacing == -1) 0 else this.resources.getDimensionPixelOffset(vSpacing),
            includeEdge = includeEdge
        )
    )
}

/**
 *  Add horizontal spacing to RecyclerView.
 *
 *  @param spacing Horizontal spacing.
 *  @param includeEdge Add spacing to edge.
 */
fun RecyclerView.withHorizontalSpacing(
    @DimenRes spacing: Int,
    includeEdge: Boolean = true
) = withSpacing(spacing, -1, includeEdge)

/**
 *  Add vertical spacing to RecyclerView.
 *
 *  @param spacing Vertical spacing.
 *  @param includeEdge Add spacing to edge.
 */
fun RecyclerView.withVerticalSpacing(
    @DimenRes spacing: Int,
    includeEdge: Boolean = true
) = withSpacing(-1, spacing, includeEdge)

/**
 *  Set RecyclerView has fixed size.
 */
fun RecyclerView.isFixedSize() = this.setHasFixedSize(true)

/**
 *  Disable RecyclerView default animator.
 */
fun RecyclerView.disableAnimator() {
    (this.itemAnimator as? SimpleItemAnimator)?.supportsChangeAnimations = false
}

/**
 *  Snap item to position.
 *
 *  @param position Target position.
 *  @param snapMode Snap mode.
 */
fun RecyclerView.smoothSnapToPosition(
    position: Int,
    snapMode: Int = LinearSmoothScroller.SNAP_TO_START
) {
    val smoothScroller = object : LinearSmoothScroller(this.context) {
        override fun getVerticalSnapPreference(): Int = snapMode
        override fun getHorizontalSnapPreference(): Int = snapMode
    }
    smoothScroller.targetPosition = position
    layoutManager?.startSmoothScroll(smoothScroller)
}