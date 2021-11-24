package com.project.mvcapp.core

interface ObservableViewContract<LISTENER : BaseListener> : RootViewContract {
    fun registerListener(listener: LISTENER)
    fun unregisterListener(listener: LISTENER)
}