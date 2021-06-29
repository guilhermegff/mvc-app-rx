package com.project.hotmartapp.ui.establishment.component.establishment

import com.project.hotmartservice.model.Week

data class EstablishmentViewItem(
    val title : String,
    val rating : Double,
    val about: String,
    val schedule: Week,
    val phone: String,
    val adress: String)