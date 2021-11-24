package com.project.mvcapp.ui.establishment.component.reviews

import com.project.mvcapp.core.BaseListener
import com.project.mvcapp.core.ObservableViewContract

interface ReviewItemViewContract : ObservableViewContract<ReviewItemViewContract.Listener> {
    interface Listener : BaseListener

    fun bind(reviewViewItem: ReviewViewItem)
}