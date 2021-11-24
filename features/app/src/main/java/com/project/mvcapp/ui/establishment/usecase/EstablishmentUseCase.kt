package com.project.mvcapp.ui.establishment.usecase

import com.project.service.DataSource
import com.project.service.model.Establishment
import io.reactivex.Single
import io.reactivex.disposables.Disposable

class EstablishmentUseCase(private val dataSource: DataSource) : BaseEstablishmentUseCase {

    override var disposables = HashSet<Disposable>()

    override fun loadEstablishment(id: String) : Single<Result<Establishment>> {
        return dataSource.establishment(id)
            .map {
                Result.success(it)
            }
            .onErrorReturn {
                Result.failure(it)
            }
    }
}