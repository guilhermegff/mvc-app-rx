package com.project.mvcapp.ui.locationslist.view.controller

import com.project.mvcapp.core.BaseListener
import com.project.mvcapp.core.ObservableViewContract
import com.project.mvcapp.ui.locationslist.component.LocationViewItem

interface LocationsListViewContract : ObservableViewContract<LocationsListViewContract.Listener> {
    interface Listener : BaseListener {
        fun onLocationClick(locationViewItem: LocationViewItem)
        fun onErrorViewClick()
    }
    fun bindViews()
    fun showLoading()
    fun hideLoading()
    fun showLocations(locations: ArrayList<LocationViewItem>)
    fun showError()
}