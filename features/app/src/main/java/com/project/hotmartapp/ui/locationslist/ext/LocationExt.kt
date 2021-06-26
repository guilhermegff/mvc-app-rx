package com.project.hotmartapp.ui.locationslist.ext

import com.project.hotmartapp.ui.locationslist.component.LocationViewItem
import com.project.hotmartservice.model.Location

fun Location.toLocationViewItem() = LocationViewItem(id, type, "", rating, "")