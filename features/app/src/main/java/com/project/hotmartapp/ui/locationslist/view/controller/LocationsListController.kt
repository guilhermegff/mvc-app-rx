package com.project.hotmartapp.ui.locationslist.view.controller

import com.project.hotmartapp.core.BaseController
import com.project.hotmartapp.core.BaseSchedulerProvider
import com.project.hotmartapp.core.BaseScreenNavigator
import com.project.hotmartapp.ui.locationslist.component.LocationViewItem
import com.project.hotmartapp.ui.locationslist.component.LocationsAdapterListener
import com.project.hotmartapp.ui.locationslist.ext.toLocationViewItem
import com.project.hotmartapp.ui.locationslist.usecase.BaseLocationsListUseCase
import com.project.hotmartservice.model.Locations
import timber.log.Timber

class LocationsListController(private val locationsListUseCase: BaseLocationsListUseCase,
                              private val schedulerProvider: BaseSchedulerProvider,
                              private val screenNavigator: BaseScreenNavigator
) : BaseController<LocationsListViewContract>(), LocationsListViewContract.Listener, LocationsAdapterListener {

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

    private fun loadLocations() {
        locationsListUseCase.loadLocations()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnSubscribe {
                viewContract.hideViews()
                viewContract.showLoading()
            }
            .doFinally { viewContract.hideLoading() }
            .subscribe({
                when {
                    it.isSuccess -> {
                        val locations = it.getOrNull() ?: Locations(arrayListOf())
                        locations.collection
                            .map { location -> location.toLocationViewItem() }
                            .let { newCollection -> viewContract.showLocations(newCollection as ArrayList<LocationViewItem>) }
                    }
                    it.isFailure -> { viewContract.showError() }
                }
            }, { Timber.e(it, "loadStores: %s", it.message) })
            .run { disposables.add(this) }
    }

    override fun onErrorViewClick() {
        loadLocations()
    }

    override fun onLocationClick(locationViewItem: LocationViewItem) {
        screenNavigator.toDetailScreen(locationViewItem)
    }
}