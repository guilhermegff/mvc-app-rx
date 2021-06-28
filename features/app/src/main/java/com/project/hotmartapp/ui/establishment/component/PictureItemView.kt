package com.project.hotmartapp.ui.establishment.component

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.project.hotmartapp.R
import com.project.hotmartapp.core.ObservableView

class PictureItemView(layoutInflater: LayoutInflater, viewGroup: ViewGroup?)
    : ObservableView<PictureItemViewContract.Listener>(layoutInflater, viewGroup, R.layout.item_picture),
    PictureItemViewContract {

    override fun bind(pictureViewItem: PictureViewItem) {
        val thumbnail = rootView.findViewById<ImageView>(R.id.thumbnailView)
        thumbnail.setImageDrawable(ContextCompat.getDrawable(thumbnail.context, R.drawable.download))

        rootView.setOnClickListener {
            listeners.forEach {
                it.onPictureClick(pictureViewItem)
            }
        }
    }
}