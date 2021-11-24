package com.project.mvcapp.core.factories

import com.project.mvcapp.ui.establishment.component.pictures.PicturesAdapter
import com.project.mvcapp.ui.establishment.component.reviews.ReviewsAdapter
import com.project.mvcapp.ui.locationslist.component.LocationsAdapter

class AdapterFactory(private val adapterViewFactory: AdapterViewFactory) {
    fun provideLocationsAdapter() = LocationsAdapter(arrayListOf(), adapterViewFactory)
    fun providePicturesAdapter() = PicturesAdapter(arrayListOf(), adapterViewFactory)
    fun provideReviewsAdapter() = ReviewsAdapter(arrayListOf(), adapterViewFactory)
}