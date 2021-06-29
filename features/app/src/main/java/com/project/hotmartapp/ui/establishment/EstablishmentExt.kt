package com.project.hotmartapp.ui.establishment

import com.project.hotmartapp.ui.establishment.component.establishment.EstablishmentViewItem
import com.project.hotmartservice.model.Establishment

fun Establishment.toEstablishmentViewItem() = EstablishmentViewItem(name, rating, about, schedule, phone, adress)