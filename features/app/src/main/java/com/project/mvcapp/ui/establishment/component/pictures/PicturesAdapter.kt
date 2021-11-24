package com.project.mvcapp.ui.establishment.component.pictures

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.mvcapp.core.factories.AdapterViewFactory

class PicturesAdapter(private val collection: ArrayList<PictureViewItem>, private val adapterViewFactory: AdapterViewFactory)
    : RecyclerView.Adapter<PicturesAdapter.ViewHolder>(), PictureItemViewContract.Listener {

    private lateinit var picturesAdapterListener : PicturesAdapterListener

    inner class ViewHolder(private val pictureItemViewContract: PictureItemViewContract) :
        RecyclerView.ViewHolder(pictureItemViewContract.rootView) {
        fun bind(pictureViewItem: PictureViewItem) {
            pictureItemViewContract.bind(pictureViewItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return adapterViewFactory.providePictureItemView(parent).let {
            it.registerListener(this)
            ViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(collection[position])
    }

    override fun getItemCount() = collection.size

    fun add(items: ArrayList<PictureViewItem>) {
        collection.addAll(items)
        notifyDataSetChanged()
    }

    fun clear() {
        collection.clear()
        notifyDataSetChanged()
    }

    override fun onPictureClick(pictureViewItem: PictureViewItem) {
        picturesAdapterListener.onPictureClick(pictureViewItem)
    }

    fun registerListener(picturesAdapterListener: PicturesAdapterListener) {
        this.picturesAdapterListener = picturesAdapterListener
    }
}