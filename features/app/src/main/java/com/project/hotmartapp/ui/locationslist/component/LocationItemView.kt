package com.project.hotmartapp.ui.locationslist.component

import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.hotmartapp.R
import com.project.hotmartapp.core.ObservableView

class LocationItemView(layoutInflater: LayoutInflater, viewGroup: ViewGroup?)
    : ObservableView<LocationItemViewContract.Listener>(layoutInflater, viewGroup, R.layout.item_location), LocationItemViewContract {

    override fun bind(locationViewItem: LocationViewItem) {
        //TODO("Not yet implemented")
    }
}