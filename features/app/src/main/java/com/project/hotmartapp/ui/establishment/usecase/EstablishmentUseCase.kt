package com.project.hotmartapp.ui.establishment.usecase

import com.project.hotmartservice.HotMartDataSource
import com.project.hotmartservice.model.Establishment
import io.reactivex.Single

class EstablishmentUseCase(private val hotMartDataSource: HotMartDataSource) {
    fun loadEstablishment(id: String) : Single<Result<Establishment>> {
        return hotMartDataSource.establishment(id)
            .map {
                Result.success(it)
            }
            .onErrorReturn {
                Result.failure(it)
            }
    }
}