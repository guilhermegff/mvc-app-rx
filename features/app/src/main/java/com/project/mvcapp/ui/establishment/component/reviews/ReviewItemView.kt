package com.project.mvcapp.ui.establishment.component.reviews

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.project.mvcapp.R
import com.project.mvcapp.core.ObservableView
import com.project.mvcapp.core.ext.loadImageInCircle

class ReviewItemView (layoutInflater: LayoutInflater, viewGroup: ViewGroup?)
    : ObservableView<ReviewItemViewContract.Listener>(layoutInflater, viewGroup, R.layout.item_review),
    ReviewItemViewContract {

    override fun bind(reviewViewItem: ReviewViewItem) {
        rootView.findViewById<ImageView>(R.id.thumbnailView).loadImageInCircle("")
        rootView.findViewById<RatingBar>(R.id.ratingBarView).rating = reviewViewItem.rating.toFloat()
        rootView.findViewById<TextView>(R.id.titleView).text = reviewViewItem.title
        rootView.findViewById<TextView>(R.id.reviewView).text = reviewViewItem.review
        rootView.findViewById<TextView>(R.id.identificationView).text = reviewViewItem.identification
    }
}