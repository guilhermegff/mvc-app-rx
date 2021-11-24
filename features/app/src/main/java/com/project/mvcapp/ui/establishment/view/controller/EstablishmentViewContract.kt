package com.project.mvcapp.ui.establishment.view.controller

import com.project.mvcapp.core.BaseListener
import com.project.mvcapp.core.ObservableViewContract
import com.project.mvcapp.ui.establishment.component.establishment.EstablishmentViewItem
import com.project.mvcapp.ui.establishment.component.reviews.ReviewViewItem

interface EstablishmentViewContract : ObservableViewContract<EstablishmentViewContract.Listener> {
    interface Listener : BaseListener {
        fun onMoreReviewsClick()
        fun onBackButtonClick()
        fun onErrorViewClick()
    }

    fun showEstablishment(establishmentViewItem: EstablishmentViewItem)
    fun showContacts(establishmentViewItem: EstablishmentViewItem)
    fun showPictures()
    fun showSchedule(establishmentViewItem: EstablishmentViewItem)
    fun showReviewsCount(total: Int)
    fun showReviews(reviews: ArrayList<ReviewViewItem>)
    fun showAllReviews(reviews: ArrayList<ReviewViewItem>)
    fun showLoading()
    fun showError()
    fun hideLoading()
    fun bindBackButton()
    fun bindReviewsButton()
}