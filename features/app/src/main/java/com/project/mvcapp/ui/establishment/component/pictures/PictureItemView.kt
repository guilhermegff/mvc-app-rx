package com.project.mvcapp.ui.establishment.component.pictures

import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.mvcapp.R
import com.project.mvcapp.core.ObservableView

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