package com.project.mvcapp.ui.locationslist.component

import com.project.mvcapp.core.BaseListener
import com.project.mvcapp.core.ObservableViewContract

interface LocationItemViewContract : ObservableViewContract<LocationItemViewContract.Listener> {
    interface Listener : BaseListener {
        fun onLocationClick(locationViewItem: LocationViewItem)
    }

    fun bind(locationViewItem: LocationViewItem)
}