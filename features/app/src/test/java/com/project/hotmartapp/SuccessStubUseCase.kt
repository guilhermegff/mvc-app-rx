package com.project.hotmartapp

import com.project.hotmartapp.ui.establishment.usecase.BaseEstablishmentUseCase
import com.project.hotmartapp.ui.locationslist.usecase.BaseLocationsListUseCase
import com.project.hotmartservice.model.Establishment
import com.project.hotmartservice.model.Locations
import com.project.hotmartservice.model.Week
import com.project.hotmartservice.model.WorkDay
import io.reactivex.Single
import io.reactivex.disposables.Disposable

class SuccessStubUseCase : BaseLocationsListUseCase, BaseEstablishmentUseCase {

    override var disposables = HashSet<Disposable>()

    override fun loadLocations(): Single<Result<Locations>> =
        Single.just(Result.success(Locations(arrayListOf())))

    override fun loadEstablishment(id: String): Single<Result<Establishment>> =
        Single.just(Result.success(Establishment("", 0.0, "", 0, "",
            Week(WorkDay(0, "", "", ""), null, null, null, null, null,
                null), "", "Street, disctrict, number, city, state")
        ))
}