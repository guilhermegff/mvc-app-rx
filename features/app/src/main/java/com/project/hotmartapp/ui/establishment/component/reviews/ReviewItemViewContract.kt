package com.project.hotmartapp.ui.establishment.component.reviews

import com.project.hotmartapp.core.BaseListener
import com.project.hotmartapp.core.ObservableViewContract

interface ReviewItemViewContract : ObservableViewContract<ReviewItemViewContract.Listener> {
    interface Listener : BaseListener

    fun bind(reviewViewItem: ReviewViewItem)
}