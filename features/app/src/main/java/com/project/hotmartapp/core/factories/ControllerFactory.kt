package com.project.hotmartapp.core.factories

import com.project.hotmartapp.ui.establishment.view.controller.EstablishmentController
import com.project.hotmartapp.ui.locationslist.view.controller.LocationsListController

class ControllerFactory(private val appProvider: AppProvider) {
    fun provideLocationsListController() = LocationsListController(
        appProvider.useCaseFactory.provideLocationsListUseCase(),
        appProvider.schedulerProvider,
        appProvider.screenNavigator
    )
    fun provideEstablishmentController(id: String) = EstablishmentController(
        appProvider.useCaseFactory.provideEstablishmentUseCase(),
        appProvider.schedulerProvider,
        id,
        appProvider.screenNavigator
    )
}