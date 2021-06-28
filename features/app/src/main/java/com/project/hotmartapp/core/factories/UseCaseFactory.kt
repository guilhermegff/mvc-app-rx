package com.project.hotmartapp.core.factories

import com.project.hotmartapp.ui.establishment.usecase.EstablishmentUseCase
import com.project.hotmartapp.ui.locationslist.usecase.LocationsListUseCase
import com.project.hotmartservice.HotMartApi
import com.project.hotmartservice.HotMartRepository

class UseCaseFactory()  {
    fun provideLocationsListUseCase() = LocationsListUseCase(HotMartRepository.getInstance(HotMartApi))
    fun provideEstablishmentUseCase() = EstablishmentUseCase(HotMartRepository.getInstance(HotMartApi))
}