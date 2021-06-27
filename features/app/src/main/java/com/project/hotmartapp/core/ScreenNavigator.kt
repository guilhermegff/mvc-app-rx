package com.project.hotmartapp.core

import com.project.hotmartapp.ui.locationslist.component.LocationViewItem

class ScreenNavigator(private val screenNavigatorListener: ScreenNavigatorListener) : BaseScreenNavigator {
    override fun toDetailScreen(locationViewItem: LocationViewItem) {
        screenNavigatorListener.openDetailScreen(locationViewItem)
    }
}