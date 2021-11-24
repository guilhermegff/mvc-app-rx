package com.project.mvcapp.core.ext

import android.animation.ObjectAnimator
import android.view.View

internal const val ROTATION_DURATION = 750L

fun View.rotate() {
    val rotation = ObjectAnimator.ofFloat(this, "rotation", 0F, 360F)
    rotation.duration = ROTATION_DURATION
    rotation.start()
}