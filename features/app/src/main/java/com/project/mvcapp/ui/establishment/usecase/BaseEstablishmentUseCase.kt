package com.project.mvcapp.ui.establishment.usecase

import com.project.mvcapp.core.BaseUseCase
import com.project.service.model.Establishment
import io.reactivex.Single

interface BaseEstablishmentUseCase : BaseUseCase {
    fun loadEstablishment(id: String) : Single<Result<Establishment>>
}