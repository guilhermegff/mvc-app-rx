package com.project.hotmartapp.core.locationslist.view.controller

import com.project.hotmartapp.core.BaseController
import com.project.hotmartapp.core.BaseSchedulerProvider
import com.project.hotmartapp.core.locationslist.usecase.LocationsListUseCase
import com.project.hotmartservice.model.Locations
import timber.log.Timber

class LocationsListController(private val locationsListUseCase: LocationsListUseCase, private val schedulerProvider: BaseSchedulerProvider) : BaseController<LocationsListViewContract>(), LocationsListViewContract.Listener {

    override fun observeLive() {
        loadLocations()
    }

    override fun registerListener(viewContract: LocationsListViewContract) {
        super.registerListener(viewContract)
        this.viewContract.registerListener(this)
    }

    override fun onStart() {
        viewContract.registerListener(this)
    }

    override fun onStop() {
        viewContract.unregisterListener(this)
    }

    override fun initViews() {
        //TODO("Not yet implemented")
    }

    override fun loadLocations() {
        locationsListUseCase.loadLocations()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({
                when {
                    it.isSuccess -> {
                        val locations = it.getOrNull() ?: Locations(arrayListOf())
                        locations.collection.size
                    }
                    it.isFailure -> {}
                }
            }, { Timber.e(it, "loadStores: %s", it.message) })
            .run { disposables.add(this) }
    }
}