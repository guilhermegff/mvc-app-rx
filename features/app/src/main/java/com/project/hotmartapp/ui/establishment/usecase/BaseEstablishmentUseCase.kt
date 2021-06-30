package com.project.hotmartapp.ui.establishment.usecase

import com.project.hotmartapp.core.BaseUseCase
import com.project.hotmartservice.model.Establishment
import io.reactivex.Single

interface BaseEstablishmentUseCase : BaseUseCase {
    fun loadEstablishment(id: String) : Single<Result<Establishment>>
}