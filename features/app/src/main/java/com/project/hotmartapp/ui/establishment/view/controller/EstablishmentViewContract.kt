package com.project.hotmartapp.ui.establishment.view.controller

import com.project.hotmartapp.core.BaseListener
import com.project.hotmartapp.core.ObservableViewContract
import com.project.hotmartservice.model.Establishment

interface EstablishmentViewContract : ObservableViewContract<EstablishmentViewContract.Listener> {
    interface Listener : BaseListener
    fun showEstablishment(establishment: Establishment)
}