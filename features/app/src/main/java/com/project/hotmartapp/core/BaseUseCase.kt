package com.project.hotmartapp.core

import io.reactivex.disposables.Disposable

abstract class BaseUseCase {
    private var disposables = HashSet<Disposable>()

    fun clearDisposables() {
        disposables.clear()
    }
}