package com.project.hotmartapp.core

import com.project.hotmartapp.ui.locationslist.component.LocationViewItem

interface BaseScreenNavigator {
    fun toDetailScreen(locationViewItem: LocationViewItem)
    fun toLastScreen()
}