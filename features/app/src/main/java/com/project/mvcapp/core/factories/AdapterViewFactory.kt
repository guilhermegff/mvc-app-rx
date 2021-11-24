package com.project.mvcapp.core.factories

import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.mvcapp.ui.establishment.component.pictures.PictureItemView
import com.project.mvcapp.ui.establishment.component.pictures.PictureItemViewContract
import com.project.mvcapp.ui.establishment.component.reviews.ReviewItemView
import com.project.mvcapp.ui.establishment.component.reviews.ReviewItemViewContract
import com.project.mvcapp.ui.locationslist.component.LocationItemView
import com.project.mvcapp.ui.locationslist.component.LocationItemViewContract

class AdapterViewFactory(private val layoutInflater: LayoutInflater) {
    fun provideLocationItemView(viewGroup: ViewGroup?) : LocationItemViewContract = LocationItemView(layoutInflater, viewGroup)
    fun providePictureItemView(viewGroup: ViewGroup?) : PictureItemViewContract = PictureItemView(layoutInflater, viewGroup)
    fun provideReviewItemView(viewGroup: ViewGroup?) : ReviewItemViewContract = ReviewItemView(layoutInflater, viewGroup)
}