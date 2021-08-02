package com.example.common.util

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import com.example.common.util.ext.visible

object AnimationUtil {

    fun fadeIn(view: View) {
        if (view.visibility == View.VISIBLE) return

        view.apply {
            this.visible()
            this.alpha = 0f
            view.animate()
                .setDuration(200)
                .alpha(1f)
                .start()
        }
    }

    fun fadeOut(view: View, visibility: Int = View.GONE) {
        if (view.visibility != View.VISIBLE) return

        view.apply {
            this.alpha = 1f
            val animator = view.animate()
            animator.setDuration(200)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        this@apply.visibility = visibility
                        this@apply.alpha = 1f
                        super.onAnimationEnd(animation)
                        animator.setListener(null)
                    }
                })
                .alpha(0f)
                .start()
        }
    }

    fun showInFromBottom(view: View) {
        if (view.visibility == View.VISIBLE) return

        view.apply {
            var height = this.height
            if (height == 0 && this.parent is View) {
                val parentWidth = (this.parent as View).width
                val parentHeight = (this.parent as View).height
                this.measure(
                    View.MeasureSpec.makeMeasureSpec(parentWidth, View.MeasureSpec.AT_MOST),
                    View.MeasureSpec.makeMeasureSpec(parentHeight, View.MeasureSpec.AT_MOST)
                )
                height = view.measuredHeight
            }
            this.visible()
            this.alpha = 0f
            this.translationY = height.toFloat()
            this.animate()
                .setDuration(200)
                .translationY(0f)
                .alpha(1f)
                .start()
        }
    }

    fun showOutFromBottom(view: View, visibility: Int = View.GONE) {
        if (view.visibility != View.VISIBLE) return

        view.apply {
            this.alpha = 1f
            this.translationY = 0f
            val animator = this.animate()
            animator.setDuration(200)
                .translationY(view.height.toFloat())
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        this@apply.visibility = visibility
                        super.onAnimationEnd(animation)
                        animator.setListener(null)
                    }
                })
                .alpha(0f)
                .start()
        }
    }
}