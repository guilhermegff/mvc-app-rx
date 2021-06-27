package com.project.hotmartapp.core

import io.reactivex.disposables.Disposable

interface  BaseUseCase {
    var disposables : HashSet<Disposable>

    fun clearDisposables() {
        disposables.clear()
    }
}