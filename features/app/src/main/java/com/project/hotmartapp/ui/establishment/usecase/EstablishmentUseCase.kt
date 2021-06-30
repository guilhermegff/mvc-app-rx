package com.project.hotmartapp.ui.establishment.usecase

import com.project.hotmartservice.HotMartDataSource
import com.project.hotmartservice.model.Establishment
import io.reactivex.Single
import io.reactivex.disposables.Disposable

class EstablishmentUseCase(private val hotMartDataSource: HotMartDataSource) : BaseEstablishmentUseCase {

    override var disposables = HashSet<Disposable>()

    override fun loadEstablishment(id: String) : Single<Result<Establishment>> {
        return hotMartDataSource.establishment(id)
            .map {
                Result.success(it)
            }
            .onErrorReturn {
                Result.failure(it)
            }
    }
}