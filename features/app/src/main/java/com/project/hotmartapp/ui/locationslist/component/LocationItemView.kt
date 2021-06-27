package com.project.hotmartapp.ui.locationslist.component

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.project.hotmartapp.R
import com.project.hotmartapp.core.ObservableView

class LocationItemView(layoutInflater: LayoutInflater, viewGroup: ViewGroup?)
    : ObservableView<LocationItemViewContract.Listener>(layoutInflater, viewGroup, R.layout.item_location), LocationItemViewContract {

    override fun bind(locationViewItem: LocationViewItem) {
        val image = rootView.findViewById<ImageView>(R.id.thumbnailView)
        val name = rootView.findViewById<TextView>(R.id.nameView)
        val type = rootView.findViewById<TextView>(R.id.typeView)
        val ratingScore = rootView.findViewById<TextView>(R.id.ratingScoreView)
        val ratingStars = rootView.findViewById<RatingBar>(R.id.ratingStarsView)

        if(locationViewItem.rating > 4) {
            image.setImageDrawable(ContextCompat.getDrawable(image.context, R.drawable.a))
        } else  {
            image.setImageDrawable(ContextCompat.getDrawable(image.context, R.drawable.download))
        }

        name.text = locationViewItem.name
        type.text = locationViewItem.type
        ratingStars.rating = locationViewItem.rating.toFloat()
        ratingScore.text = locationViewItem.rating.toString()
    }
}