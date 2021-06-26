package com.project.hotmartapp.core.factories

import com.project.hotmartapp.ui.locationslist.component.LocationsAdapter
import com.project.hotmartapp.ui.locationslist.component.LocationsAdapterListener

class AdapterFactory(private val adapterViewFactory: AdapterViewFactory) {
    fun provideLocationsAdapter(locationsAdapterListener: LocationsAdapterListener) =
        LocationsAdapter(arrayListOf(), locationsAdapterListener, adapterViewFactory)
}