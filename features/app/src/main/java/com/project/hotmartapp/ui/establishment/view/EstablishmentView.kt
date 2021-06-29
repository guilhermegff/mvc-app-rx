package com.project.hotmartapp.ui.establishment.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import com.project.hotmartapp.R
import com.project.hotmartapp.core.ErrorView
import com.project.hotmartapp.core.ErrorViewListener
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
    EstablishmentViewContract, PicturesAdapterListener, ErrorViewListener {

    private val moreReviewsComponent = rootView.findViewById<ConstraintLayout>(R.id.moreReviewsComponent)
    private val moreReviewsView = rootView.findViewById<TextView>(R.id.moreReviewsView)
    private val progressBar = rootView.findViewById<ProgressBar>(R.id.progressBarView)
    private val errorView = rootView.findViewById<ErrorView>(R.id.errorView)

    override fun bindBackButton() {
        rootView.findViewById<ImageView>(R.id.arrowBackView).let { imageView ->
            imageView.setOnClickListener {
                listeners.forEach {
                    it.onBackButtonClick()
                }
            }
        }
    }

    override fun bindReviewsButton() {
        moreReviewsComponent.setOnClickListener {
            listeners.forEach {
                it.onMoreReviewsClick()
            }
        }
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showError() {
        errorView.errorViewListener = this
        errorView.visibility = View.VISIBLE
    }

    override fun doAction() {
        errorView.visibility = View.GONE
        listeners.forEach {
            it.onErrorViewClick()
        }
    }

    override fun showEstablishment(establishmentViewItem: EstablishmentViewItem) {
        rootView.findViewById<NestedScrollView>(R.id.nestedComponentView).visibility = View.VISIBLE
        rootView.findViewById<TextView>(R.id.establishmentTitleView).text = establishmentViewItem.title
        rootView.findViewById<RatingBar>(R.id.ratingStarsView).rating = establishmentViewItem.rating.toFloat()
        rootView.findViewById<TextView>(R.id.ratingScoreView).text = establishmentViewItem.rating.toString()
    }

    override fun showPictures() {
        rootView.findViewById<RecyclerView>(R.id.picturesCollectionView).let { recycler ->
            recycler.adapter = picturesAdapter
            recycler.visibility = View.VISIBLE
        }
        picturesAdapter.registerListener(this)
        picturesAdapter.add(createItems())
    }

    override fun showReviewsCount(total: Int) {
        moreReviewsView.text = rootView.context.resources.getString(R.string.more_reviews, total)
    }

    override fun showReviews(reviews: ArrayList<ReviewViewItem>) {
        rootView.findViewById<RecyclerView>(R.id.reviewsCollectionView).let { recycler ->
            recycler.adapter = reviewsAdapter
            recycler.visibility = View.VISIBLE
        }
        reviewsAdapter.add(reviews)
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