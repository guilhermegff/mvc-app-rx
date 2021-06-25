package com.project.hotmartapp.core.locationslist.view.controller

import com.project.hotmartapp.core.BaseListener
import com.project.hotmartapp.core.ObservableViewContract

interface LocationsListViewContract : ObservableViewContract<LocationsListViewContract.Listener> {
    interface Listener : BaseListener {
        fun loadLocations()
    }
    fun bindViews()
}