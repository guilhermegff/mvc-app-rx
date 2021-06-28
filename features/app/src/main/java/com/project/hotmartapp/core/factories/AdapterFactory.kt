package com.project.hotmartapp.core.factories

import com.project.hotmartapp.ui.establishment.component.PicturesAdapter
import com.project.hotmartapp.ui.locationslist.component.LocationsAdapter

class AdapterFactory(private val adapterViewFactory: AdapterViewFactory) {
    fun provideLocationsAdapter() = LocationsAdapter(arrayListOf(), adapterViewFactory)
    fun providePicturesAdapter() = PicturesAdapter(arrayListOf(), adapterViewFactory)
}