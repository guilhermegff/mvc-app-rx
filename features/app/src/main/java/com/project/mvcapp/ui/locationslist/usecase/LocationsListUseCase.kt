package com.project.mvcapp.ui.locationslist.usecase

import com.project.service.DataSource
import com.project.service.model.Locations
import io.reactivex.Single
import io.reactivex.disposables.Disposable

class LocationsListUseCase(private val dataSource: DataSource) : BaseLocationsListUseCase {

    override var disposables = HashSet<Disposable>()

    override fun loadLocations() : Single<Result<Locations>> {
        return dataSource.locations()
            .map {
                Result.success(it)
            }
            .onErrorReturn {
                Result.failure(it)
            }
    }
}