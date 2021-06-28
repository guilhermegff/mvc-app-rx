package com.project.hotmartapp.core.factories

import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.hotmartapp.ui.establishment.component.PictureItemView
import com.project.hotmartapp.ui.establishment.component.PictureItemViewContract
import com.project.hotmartapp.ui.locationslist.component.LocationItemView
import com.project.hotmartapp.ui.locationslist.component.LocationItemViewContract

class AdapterViewFactory(private val layoutInflater: LayoutInflater) {
    fun provideLocationItemView(viewGroup: ViewGroup?) : LocationItemViewContract = LocationItemView(layoutInflater, viewGroup)
    fun providePictureItemView(viewGroup: ViewGroup?) : PictureItemViewContract = PictureItemView(layoutInflater, viewGroup)
}