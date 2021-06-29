package com.project.hotmartapp.core.factories

import com.project.hotmartapp.ui.establishment.component.pictures.PicturesAdapter
import com.project.hotmartapp.ui.establishment.component.reviews.ReviewsAdapter
import com.project.hotmartapp.ui.locationslist.component.LocationsAdapter

class AdapterFactory(private val adapterViewFactory: AdapterViewFactory) {
    fun provideLocationsAdapter() = LocationsAdapter(arrayListOf(), adapterViewFactory)
    fun providePicturesAdapter() = PicturesAdapter(arrayListOf(), adapterViewFactory)
    fun provideReviewsAdapter() = ReviewsAdapter(arrayListOf(), adapterViewFactory)
}