package com.project.hotmartapp.ui.establishment.view.controller

import com.project.hotmartapp.core.BaseListener
import com.project.hotmartapp.core.ObservableViewContract
import com.project.hotmartapp.ui.establishment.component.establishment.EstablishmentViewItem
import com.project.hotmartapp.ui.establishment.component.reviews.ReviewViewItem

interface EstablishmentViewContract : ObservableViewContract<EstablishmentViewContract.Listener> {
    interface Listener : BaseListener {
        fun onMoreReviewsClick()
        fun onBackButtonClick()
    }

    fun showEstablishment(establishmentViewItem: EstablishmentViewItem)
    fun showPictures()
    fun showReviews(reviews: ArrayList<ReviewViewItem>, total: Int)
    fun showAllReviews(reviews: ArrayList<ReviewViewItem>)
    fun bindBackButton()
}