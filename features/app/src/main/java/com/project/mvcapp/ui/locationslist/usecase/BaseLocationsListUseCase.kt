package com.project.mvcapp.ui.locationslist.usecase

import com.project.mvcapp.core.BaseUseCase
import com.project.service.model.Locations
import io.reactivex.Single

interface BaseLocationsListUseCase : BaseUseCase {
    fun loadLocations() : Single<Result<Locations>>
}