package com.project.hotmartapp.ui.locationslist.usecase

import com.project.hotmartservice.HotMartDataSource
import com.project.hotmartservice.model.Locations
import io.reactivex.Single
import io.reactivex.disposables.Disposable

class LocationsListUseCase(private val hotMartDataSource: HotMartDataSource) : BaseLocationsListUseCase {

    override var disposables = HashSet<Disposable>()

    override fun loadLocations() : Single<Result<Locations>> {
        return hotMartDataSource.locations()
            .map {
                Result.success(it)
            }
            .onErrorReturn {
                Result.failure(it)
            }
    }
}