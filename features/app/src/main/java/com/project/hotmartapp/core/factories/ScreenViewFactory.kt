package com.project.hotmartapp.core.factories

import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.hotmartapp.ui.locationslist.component.LocationsAdapter
import com.project.hotmartapp.ui.locationslist.view.LocationsListView
import com.project.hotmartapp.ui.locationslist.view.controller.LocationsListViewContract

class ScreenViewFactory(private val layoutInflater: LayoutInflater) {
    fun provideLocationsListScreenView(viewGroup: ViewGroup?, locationsAdapter: LocationsAdapter) : LocationsListViewContract = LocationsListView(layoutInflater, viewGroup, locationsAdapter)
}