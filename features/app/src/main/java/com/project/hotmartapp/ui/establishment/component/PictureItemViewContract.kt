package com.project.hotmartapp.ui.establishment.component

import com.project.hotmartapp.core.BaseListener
import com.project.hotmartapp.core.ObservableViewContract

interface PictureItemViewContract : ObservableViewContract<PictureItemViewContract.Listener> {
    interface Listener : BaseListener {
        fun onPictureClick(pictureViewItem: PictureViewItem)
    }

    fun bind(pictureViewItem: PictureViewItem)
}