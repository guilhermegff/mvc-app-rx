package com.project.hotmartapp.core.factories

import com.project.hotmartapp.ui.locationslist.view.controller.LocationsListController

class ControllerFactory(private val appProvider: AppProvider) {
    fun provideLocationsListController() = LocationsListController(
        appProvider.useCaseFactory.provideLocationsListUseCase(),
        appProvider.schedulerProvider
    )
}