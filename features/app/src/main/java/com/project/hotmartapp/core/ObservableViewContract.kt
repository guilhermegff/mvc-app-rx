package com.project.hotmartapp.core

interface ObservableViewContract<LISTENER : BaseListener> : RootViewContract {
    fun registerListener(listener: LISTENER)
    fun unregisterListener(listener: LISTENER)
}