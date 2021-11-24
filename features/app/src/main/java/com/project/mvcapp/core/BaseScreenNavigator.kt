package com.project.mvcapp.core

import com.project.mvcapp.ui.locationslist.component.LocationViewItem

interface BaseScreenNavigator {
    fun toDetailScreen(locationViewItem: LocationViewItem)
    fun toLastScreen()
}