package com.project.hotmartapp.ui.locationslist.view.controller

import com.project.hotmartapp.core.BaseListener
import com.project.hotmartapp.core.ObservableViewContract
import com.project.hotmartapp.ui.locationslist.component.LocationViewItem

interface LocationsListViewContract : ObservableViewContract<LocationsListViewContract.Listener> {
    interface Listener : BaseListener {
        fun loadLocations()
        fun onLocationClick(locationViewItem: LocationViewItem)
    }
    fun bindViews()
    fun showLoading()
    fun hideLoading()
    fun showLocations(locations: ArrayList<LocationViewItem>)
    fun showError()
}