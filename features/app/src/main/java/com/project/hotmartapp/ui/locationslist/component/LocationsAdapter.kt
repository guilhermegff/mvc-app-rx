package com.project.hotmartapp.ui.locationslist.component

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.hotmartapp.core.factories.AdapterViewFactory

class LocationsAdapter(private val collection: ArrayList<LocationViewItem>, private val adapterViewFactory: AdapterViewFactory)
    : RecyclerView.Adapter<LocationsAdapter.ViewHolder>(), LocationItemViewContract.Listener {

    private lateinit var locationsAdapterListener : LocationsAdapterListener

    inner class ViewHolder(private val locationItemViewContract: LocationItemViewContract) :
        RecyclerView.ViewHolder(locationItemViewContract.rootView) {
        fun bind(locationViewItem: LocationViewItem) {
            locationItemViewContract.bind(locationViewItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return adapterViewFactory.provideLocationItemView(parent).let {
            it.registerListener(this)
            ViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(collection[position])
    }

    override fun getItemCount() = collection.size

    fun add(items: ArrayList<LocationViewItem>) {
        collection.addAll(items)
        notifyDataSetChanged()
    }

    fun clear() {
        collection.clear()
        notifyDataSetChanged()
    }

    override fun onLocationClick(locationViewItem: LocationViewItem) {
        locationsAdapterListener.onLocationClick(locationViewItem)
    }

    fun registerListener(locationsAdapterListener: LocationsAdapterListener) {
        this.locationsAdapterListener = locationsAdapterListener
    }
}