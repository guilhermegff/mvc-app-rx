package com.project.mvcapp.core

import com.project.mvcapp.ui.locationslist.component.LocationViewItem

interface ScreenNavigatorListener {
    fun openDetailScreen(locationViewItem: LocationViewItem)
    fun backToLastScreen()
}