package com.project.hotmartapp.core

import androidx.annotation.CallSuper
import io.reactivex.disposables.Disposable

abstract class BaseController<VIEW_CONTRACT : RootViewContract> {
    protected lateinit var viewContract : VIEW_CONTRACT
    protected var disposables = HashSet<Disposable>()

    abstract fun onStart()
    abstract fun onStop()

    abstract fun initViews()
    abstract fun observeLive()

    @CallSuper
    open fun registerListener(viewContract: VIEW_CONTRACT){
        this.viewContract = viewContract
        observeLive()
    }

    protected fun clearDisposables() {
        disposables.forEach {
            it.dispose()
        }
    }
}