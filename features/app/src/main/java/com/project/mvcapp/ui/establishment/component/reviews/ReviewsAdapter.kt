package com.project.mvcapp.ui.establishment.component.reviews

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.mvcapp.core.factories.AdapterViewFactory

class ReviewsAdapter(private val collection: ArrayList<ReviewViewItem>, private val adapterViewFactory: AdapterViewFactory)
    : RecyclerView.Adapter<ReviewsAdapter.ViewHolder>(), ReviewItemViewContract.Listener {

    inner class ViewHolder(private val reviewItemViewContract: ReviewItemViewContract) :
        RecyclerView.ViewHolder(reviewItemViewContract.rootView) {
        fun bind(reviewViewItem: ReviewViewItem) {
            reviewItemViewContract.bind(reviewViewItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return adapterViewFactory.provideReviewItemView(parent).let {
            it.registerListener(this)
            ViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(collection[position])
    }

    override fun getItemCount() = collection.size

    fun add(items: ArrayList<ReviewViewItem>) {
        collection.addAll(items)
        notifyDataSetChanged()
    }

    fun clear() {
        collection.clear()
        notifyDataSetChanged()
    }
}