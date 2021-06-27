package com.project.hotmartapp.ui.locationslist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.project.hotmartapp.R
import com.project.hotmartapp.core.ObservableView
import com.project.hotmartapp.ui.locationslist.component.LocationViewItem
import com.project.hotmartapp.ui.locationslist.component.LocationsAdapter
import com.project.hotmartapp.ui.locationslist.component.LocationsAdapterListener
import com.project.hotmartapp.ui.locationslist.view.controller.LocationsListViewContract

class LocationsListView(layoutInflater: LayoutInflater, viewGroup: ViewGroup?, private val locationsAdapter: LocationsAdapter) :
    ObservableView<LocationsListViewContract.Listener>(layoutInflater, viewGroup, R.layout.fragment_locations_list),
    LocationsListViewContract, LocationsAdapterListener {

    private val progressBar: ProgressBar = rootView.findViewById(R.id.progressBarView)

    override fun bindViews() {
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showLocations(locations: ArrayList<LocationViewItem>) {
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.locationsRecyclerView)
        recyclerView.adapter = locationsAdapter
        recyclerView.visibility = View.VISIBLE

        locationsAdapter.registerListener(this)
        locationsAdapter.add(locations)
    }

    override fun showError() {
        //TODO("Not yet implemented")
    }

    override fun onLocationClick(locationViewItem: LocationViewItem) {
        listeners.forEach {
            it.onLocationClick(locationViewItem)
        }
    }
}