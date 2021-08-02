package com.example.common.tools

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class SpacingDecoration(
    private val hSpacing: Int,
    private val vSpacing: Int,
    private val includeEdge: Boolean
) : ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)

        when (val layoutManager = parent.layoutManager) {
            is GridLayoutManager -> {
                val spanCount = layoutManager.spanCount
                val column = position % spanCount
                getGridItemOffsets(outRect, position, column, spanCount)
            }

            is StaggeredGridLayoutManager -> {
                val spanCount = layoutManager.spanCount
                val lp = view.layoutParams as StaggeredGridLayoutManager.LayoutParams
                val column = lp.spanIndex
                getGridItemOffsets(outRect, position, column, spanCount)
            }

            is LinearLayoutManager -> {
                if (layoutManager.orientation == RecyclerView.VERTICAL) {
                    outRect.left = hSpacing
                    outRect.right = hSpacing

                    if (includeEdge) {
                        if (position == 0) {
                            outRect.top = vSpacing
                        }
                        outRect.bottom = vSpacing
                    } else {
                        if (position > 0) {
                            outRect.top = vSpacing
                        }
                    }
                } else {
                    outRect.top = vSpacing
                    outRect.bottom = vSpacing

                    if (includeEdge) {
                        if (position == 0) {
                            outRect.left = hSpacing
                        }
                        outRect.right = hSpacing
                    } else {
                        if (position > 0) {
                            outRect.left = hSpacing
                        }
                    }
                }
            }
        }
    }

    private fun getGridItemOffsets(outRect: Rect, position: Int, column: Int, spanCount: Int) {
        if (includeEdge) {
            outRect.left = hSpacing * (spanCount - column) / spanCount
            outRect.right = hSpacing * (column + 1) / spanCount
            if (position < spanCount) {
                outRect.top = vSpacing
            }
            outRect.bottom = vSpacing
        } else {
            outRect.left = hSpacing * column / spanCount
            outRect.right = hSpacing * (spanCount - 1 - column) / spanCount
            if (position >= spanCount) {
                outRect.top = vSpacing
            }
        }
    }
}