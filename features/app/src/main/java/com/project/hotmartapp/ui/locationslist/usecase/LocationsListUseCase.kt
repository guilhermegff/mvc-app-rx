package com.project.hotmartapp.ui.locationslist.usecase

import com.project.hotmartapp.core.BaseUseCase
import com.project.hotmartservice.HotMartDataSource
import com.project.hotmartservice.model.Locations
import io.reactivex.Single

class LocationsListUseCase(private val hotMartDataSource: HotMartDataSource) : BaseUseCase() {

    fun loadLocations() : Single<Result<Locations>> {
        return hotMartDataSource.locations()
            .map {
                Result.success(it)
            }
            .onErrorReturn {
                Result.failure(it)
            }
    }
}