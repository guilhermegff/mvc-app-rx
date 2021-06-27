package com.project.hotmartapp.core

import com.project.hotmartapp.ui.locationslist.component.LocationViewItem

interface ScreenNavigatorListener {
    fun openDetailScreen(locationViewItem: LocationViewItem)
}