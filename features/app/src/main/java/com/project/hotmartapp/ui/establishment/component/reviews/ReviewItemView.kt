package com.project.hotmartapp.ui.establishment.component.reviews

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.project.hotmartapp.R
import com.project.hotmartapp.core.ObservableView
import com.project.hotmartapp.core.ext.loadImageInCircle

class ReviewItemView (layoutInflater: LayoutInflater, viewGroup: ViewGroup?)
    : ObservableView<ReviewItemViewContract.Listener>(layoutInflater, viewGroup, R.layout.item_review),
    ReviewItemViewContract {

    override fun bind(reviewViewItem: ReviewViewItem) {
        val thumbnail = rootView.findViewById<ImageView>(R.id.thumbnailView)
        val ratingStars = rootView.findViewById<RatingBar>(R.id.ratingBarView)
        val title = rootView.findViewById<TextView>(R.id.titleView)
        val review = rootView.findViewById<TextView>(R.id.reviewView)
        val identificationView = rootView.findViewById<TextView>(R.id.identificationView)

        thumbnail.loadImageInCircle("")
        ratingStars.rating = reviewViewItem.rating.toFloat()
        title.text = reviewViewItem.title
        review.text = reviewViewItem.review
    }
}