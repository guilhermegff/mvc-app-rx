package com.project.hotmartapp

import com.project.hotmartapp.ui.establishment.usecase.BaseEstablishmentUseCase
import com.project.hotmartapp.ui.locationslist.usecase.BaseLocationsListUseCase
import com.project.hotmartservice.model.Establishment
import com.project.hotmartservice.model.Locations
import io.reactivex.Single
import io.reactivex.disposables.Disposable

class FailureStubUseCase : BaseLocationsListUseCase, BaseEstablishmentUseCase {

    override var disposables = HashSet<Disposable>()

    override fun loadLocations(): Single<Result<Locations>> =
        Single.just(Result.failure(Throwable()))

    override fun loadEstablishment(id: String): Single<Result<Establishment>> =
        Single.just(Result.failure(Throwable()))
}