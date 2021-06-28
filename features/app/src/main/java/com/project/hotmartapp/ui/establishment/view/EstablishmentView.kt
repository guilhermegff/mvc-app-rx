package com.project.hotmartapp.ui.establishment.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.hotmartapp.R
import com.project.hotmartapp.core.ObservableView
import com.project.hotmartapp.ui.establishment.view.controller.EstablishmentViewContract

class EstablishmentView(layoutInflater: LayoutInflater, viewGroup: ViewGroup?) :
    ObservableView<EstablishmentViewContract.Listener>(layoutInflater, viewGroup, R.layout.fragment_establishment), EstablishmentViewContract {


}