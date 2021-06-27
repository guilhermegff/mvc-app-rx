package com.project.hotmartapp

import com.project.hotmartapp.ui.locationslist.usecase.BaseLocationsListUseCase
import com.project.hotmartservice.model.Locations
import io.reactivex.Single
import io.reactivex.disposables.Disposable

class SuccessStubUseCase : BaseLocationsListUseCase {

    override var disposables = HashSet<Disposable>()

    override fun loadLocations(): Single<Result<Locations>> =
        Single.just(Result.success(Locations(arrayListOf())))
}