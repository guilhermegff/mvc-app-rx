package com.project.hotmartapp.ui.establishment.component.reviews

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.project.hotmartapp.R
import com.project.hotmartapp.core.ObservableView
import com.project.hotmartapp.core.ext.loadImageInCircle

class ReviewItemView (layoutInflater: LayoutInflater, viewGroup: ViewGroup?)
    : ObservableView<ReviewItemViewContract.Listener>(layoutInflater, viewGroup, R.layout.item_review),
    ReviewItemViewContract {

    override fun bind(reviewViewItem: ReviewViewItem) {
        val thumbnail = rootView.findViewById<ImageView>(R.id.thumbnailView)
        thumbnail.loadImageInCircle("")
    }
}