package com.project.hotmartapp.ui.establishment.component.pictures

import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.hotmartapp.R
import com.project.hotmartapp.core.ObservableView

class PictureItemView(layoutInflater: LayoutInflater, viewGroup: ViewGroup?)
    : ObservableView<PictureItemViewContract.Listener>(layoutInflater, viewGroup, R.layout.item_picture),
    PictureItemViewContract {

    override fun bind(pictureViewItem: PictureViewItem) {
        rootView.setOnClickListener {
            listeners.forEach {
                it.onPictureClick(pictureViewItem)
            }
        }
    }
}