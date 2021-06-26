package com.project.hotmartapp.ui.locationslist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.hotmartapp.R
import com.project.hotmartapp.core.ObservableView
import com.project.hotmartapp.ui.locationslist.view.controller.LocationsListViewContract

class LocationsListView(layoutInflater: LayoutInflater, viewGroup: ViewGroup?) :
    ObservableView<LocationsListViewContract.Listener>(layoutInflater, viewGroup, R.layout.fragment_locations_list),
    LocationsListViewContract {

    override fun bindViews() {
    }
}