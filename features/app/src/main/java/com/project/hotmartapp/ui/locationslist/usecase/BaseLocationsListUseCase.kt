package com.project.hotmartapp.ui.locationslist.usecase

import com.project.hotmartapp.core.BaseUseCase
import com.project.hotmartservice.model.Locations
import io.reactivex.Single

interface BaseLocationsListUseCase : BaseUseCase {
    fun loadLocations() : Single<Result<Locations>>
}