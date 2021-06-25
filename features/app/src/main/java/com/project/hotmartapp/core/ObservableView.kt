package com.project.hotmartapp.core

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes

abstract class ObservableView<LISTENER : BaseListener>(layoutInflater: LayoutInflater, viewGroup: ViewGroup?, @LayoutRes layoutId: Int)
    : BaseView(layoutInflater, viewGroup, layoutId), ObservableViewContract<LISTENER> {

    val listeners = HashSet<LISTENER>()

    override fun registerListener(listener: LISTENER) {
        listeners.add(listener)
    }

    override fun unregisterListener(listener: LISTENER) {
        listeners.remove(listener)
    }
}