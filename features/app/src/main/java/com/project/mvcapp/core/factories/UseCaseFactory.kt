package com.project.mvcapp.core.factories

import com.project.mvcapp.ui.establishment.usecase.EstablishmentUseCase
import com.project.mvcapp.ui.locationslist.usecase.LocationsListUseCase
import com.project.service.Api
import com.project.service.Repository

class UseCaseFactory()  {
    fun provideLocationsListUseCase() = LocationsListUseCase(Repository.getInstance(Api))
    fun provideEstablishmentUseCase() = EstablishmentUseCase(Repository.getInstance(Api))
}