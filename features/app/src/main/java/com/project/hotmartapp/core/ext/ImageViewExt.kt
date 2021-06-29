package com.project.hotmartapp.core.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.project.hotmartapp.R

fun ImageView.loadImageInCircle(imageUrl: String,
                        placeholder: Int = R.drawable.circle_fill,
                        error: Int = R.drawable.circle_fill) {
    Glide.with(context)
        .load(imageUrl)
        .circleCrop()
        .placeholder(placeholder)
        .error(error)
        .into(this)
}