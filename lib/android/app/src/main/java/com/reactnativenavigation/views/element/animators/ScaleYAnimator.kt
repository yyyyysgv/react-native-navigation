package com.reactnativenavigation.views.element.animators

import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.View
import android.view.ViewGroup
import com.facebook.react.views.text.ReactTextView
import com.reactnativenavigation.parse.SharedElementTransitionOptions

class ScaleYAnimator(from: View, to: View) : PropertyAnimatorCreator<ViewGroup>(from, to) {
    override fun shouldAnimateProperty(fromChild: ViewGroup, toChild: ViewGroup): Boolean {
        return fromChild.childCount == 0 && toChild.childCount == 0
    }

    override fun excludedViews() = listOf(ReactTextView::class.java)

    override fun create(options: SharedElementTransitionOptions): Animator {
        return ObjectAnimator
                .ofFloat(to, View.SCALE_Y, from.height.toFloat() / to.height, 1f)
                .setDuration(options.getDuration())
    }
}