package com.project.mvcapp

import com.project.mvcapp.ui.establishment.usecase.BaseEstablishmentUseCase
import com.project.mvcapp.ui.locationslist.usecase.BaseLocationsListUseCase
import com.project.service.model.Establishment
import com.project.service.model.Locations
import com.project.service.model.Week
import com.project.service.model.WorkDay
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