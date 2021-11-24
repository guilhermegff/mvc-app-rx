package com.project.mvcapp.core.factories

import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.mvcapp.ui.establishment.component.pictures.PicturesAdapter
import com.project.mvcapp.ui.establishment.component.reviews.ReviewsAdapter
import com.project.mvcapp.ui.establishment.view.EstablishmentView
import com.project.mvcapp.ui.establishment.view.controller.EstablishmentViewContract
import com.project.mvcapp.ui.locationslist.component.LocationsAdapter
import com.project.mvcapp.ui.locationslist.view.LocationsListView
import com.project.mvcapp.ui.locationslist.view.controller.LocationsListViewContract

class ScreenViewFactory(private val layoutInflater: LayoutInflater) {
    fun provideLocationsListScreenView(viewGroup: ViewGroup?, locationsAdapter: LocationsAdapter) : LocationsListViewContract = LocationsListView(layoutInflater, viewGroup, locationsAdapter)
    fun provideEstablishmentScreenView(viewGroup: ViewGroup?, picturesAdapter: PicturesAdapter, reviewsAdapter: ReviewsAdapter) : EstablishmentViewContract = EstablishmentView(layoutInflater, viewGroup, picturesAdapter, reviewsAdapter)
}