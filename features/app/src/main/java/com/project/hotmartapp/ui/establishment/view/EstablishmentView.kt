package com.project.hotmartapp.ui.establishment.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.project.hotmartapp.R
import com.project.hotmartapp.core.ObservableView
import com.project.hotmartapp.ui.establishment.component.establishment.EstablishmentViewItem
import com.project.hotmartapp.ui.establishment.component.pictures.PictureViewItem
import com.project.hotmartapp.ui.establishment.component.pictures.PicturesAdapter
import com.project.hotmartapp.ui.establishment.component.pictures.PicturesAdapterListener
import com.project.hotmartapp.ui.establishment.component.reviews.ReviewViewItem
import com.project.hotmartapp.ui.establishment.component.reviews.ReviewsAdapter
import com.project.hotmartapp.ui.establishment.view.controller.EstablishmentViewContract
import timber.log.Timber

class EstablishmentView(layoutInflater: LayoutInflater, viewGroup: ViewGroup?,
                        private val picturesAdapter: PicturesAdapter,
                        private val reviewsAdapter: ReviewsAdapter)
    : ObservableView<EstablishmentViewContract.Listener>(layoutInflater, viewGroup, R.layout.fragment_establishment),
    EstablishmentViewContract, PicturesAdapterListener {

    private val moreReviewsComponent = rootView.findViewById<ConstraintLayout>(R.id.moreReviewsComponent)

    override fun bindBackButton() {
        rootView.findViewById<ImageView>(R.id.arrowBackView).also { imageView ->
            imageView.setOnClickListener {
                listeners.forEach {
                    it.onBackButtonClick()
                }
            }
        }
    }

    override fun showEstablishment(establishmentViewItem: EstablishmentViewItem) {
        val title = rootView.findViewById<TextView>(R.id.establishmentTitleView)
        title.text = establishmentViewItem.title

        val ratingStars = rootView.findViewById<RatingBar>(R.id.ratingStarsView)
        ratingStars.rating = establishmentViewItem.rating.toFloat()

        val ratingScore = rootView.findViewById<TextView>(R.id.ratingScoreView)
        ratingScore.text = establishmentViewItem.rating.toString()
    }

    override fun showPictures() {
        val picturesCollection = rootView.findViewById<RecyclerView>(R.id.picturesCollectionView)
        picturesAdapter.registerListener(this)
        picturesAdapter.add(createItems())

        picturesCollection.adapter = picturesAdapter

        picturesCollection.visibility = View.VISIBLE
    }

    override fun showReviews(reviews: ArrayList<ReviewViewItem>, total: Int) {
        val moreReviewsView = rootView.findViewById<TextView>(R.id.moreReviewsView)
        moreReviewsView.text = rootView.resources.getString(R.string.more_reviews, total)
        moreReviewsComponent.setOnClickListener {
            listeners.forEach {
                it.onMoreReviewsClick()
            }
        }

        val reviewsCollection = rootView.findViewById<RecyclerView>(R.id.reviewsCollectionView)
        reviewsAdapter.add(reviews)
        reviewsCollection.adapter = reviewsAdapter
        reviewsCollection.visibility = View.VISIBLE
    }

    override fun showAllReviews(reviews: ArrayList<ReviewViewItem>) {
        reviewsAdapter.clear()
        reviewsAdapter.add(reviews)
        moreReviewsComponent.visibility = View.GONE
    }

    override fun onPictureClick(pictureViewItem: PictureViewItem) {
        Toast.makeText(rootView.context, "Not Implemented", Toast.LENGTH_SHORT).show()
        Timber.e("OnPictureClick not implemented")
    }

    private fun createItems() : ArrayList<PictureViewItem> {
        return arrayListOf(
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem("")
        )
    }
}