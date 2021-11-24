package com.project.mvcapp.ui.establishment.component.establishment

import com.project.service.model.Week

data class EstablishmentViewItem(
    val title : String,
    val rating : Double,
    val about: String,
    val schedule: Week,
    val phone: String,
    val adress: String)