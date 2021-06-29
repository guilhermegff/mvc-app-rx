package com.project.hotmartapp.ui.establishment.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.hotmartapp.R
import com.project.hotmartapp.core.ObservableView
import com.project.hotmartapp.ui.establishment.component.pictures.PictureViewItem
import com.project.hotmartapp.ui.establishment.component.pictures.PicturesAdapter
import com.project.hotmartapp.ui.establishment.component.pictures.PicturesAdapterListener
import com.project.hotmartapp.ui.establishment.component.reviews.ReviewViewItem
import com.project.hotmartapp.ui.establishment.component.reviews.ReviewsAdapter
import com.project.hotmartapp.ui.establishment.view.controller.EstablishmentViewContract
import com.project.hotmartservice.model.Establishment

class EstablishmentView(layoutInflater: LayoutInflater, viewGroup: ViewGroup?,
                        private val picturesAdapter: PicturesAdapter,
                        private val reviewsAdapter: ReviewsAdapter)
    : ObservableView<EstablishmentViewContract.Listener>(layoutInflater, viewGroup, R.layout.fragment_establishment),
    EstablishmentViewContract, PicturesAdapterListener {

    override fun showEstablishment(establishment: Establishment) {
        val picturesCollection = rootView.findViewById<RecyclerView>(R.id.picturesCollectionView)
        picturesAdapter.add(createItems())

        picturesCollection.adapter = picturesAdapter

        picturesCollection.visibility = View.VISIBLE

        val reviewsCollection = rootView.findViewById<RecyclerView>(R.id.reviewsCollectionView)
        reviewsAdapter.add(createReviewItems())

        reviewsCollection.adapter = reviewsAdapter

        reviewsCollection.visibility = View.VISIBLE
    }

    override fun onPictureClick(pictureViewItem: PictureViewItem) {
        //TODO("Not yet implemented")
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

    private fun createReviewItems() : ArrayList<ReviewViewItem> {
        return arrayListOf(
            ReviewViewItem("", 0.0, "", "", ""),
            ReviewViewItem("", 0.0, "", "", ""),
            ReviewViewItem("", 0.0, "", "", ""),
            ReviewViewItem("", 0.0, "", "", ""),
            ReviewViewItem("", 0.0, "", "", ""),
            ReviewViewItem("", 0.0, "", "", ""),
            ReviewViewItem("", 0.0, "", "", ""),
            ReviewViewItem("", 0.0, "", "", ""),
            ReviewViewItem("", 0.0, "", "", ""),
            ReviewViewItem("", 0.0, "", "", ""),
        )
    }
}