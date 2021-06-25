package com.project.hotmartapp.core.factories

import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.hotmartapp.core.locationslist.view.LocationsListView
import com.project.hotmartapp.core.locationslist.view.controller.LocationsListViewContract

class ScreenViewFactory(private val layoutInflater: LayoutInflater) {
    fun provideLocationsListScreenView(viewGroup: ViewGroup?) : LocationsListViewContract = LocationsListView(layoutInflater, viewGroup)
}