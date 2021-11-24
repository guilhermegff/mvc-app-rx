package com.project.mvcapp.ui.establishment.component.pictures

import com.project.mvcapp.core.BaseListener
import com.project.mvcapp.core.ObservableViewContract

interface PictureItemViewContract : ObservableViewContract<PictureItemViewContract.Listener> {
    interface Listener : BaseListener {
        fun onPictureClick(pictureViewItem: PictureViewItem)
    }

    fun bind(pictureViewItem: PictureViewItem)
}