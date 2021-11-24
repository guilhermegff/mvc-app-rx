package com.project.mvcapp.ui.locationslist.ext

import com.project.mvcapp.ui.locationslist.component.LocationViewItem
import com.project.service.model.Location

fun Location.toLocationViewItem() = LocationViewItem(id, "", name, type, rating, "")