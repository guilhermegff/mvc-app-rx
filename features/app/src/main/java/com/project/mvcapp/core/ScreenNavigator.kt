package com.project.mvcapp.core

import com.project.mvcapp.ui.locationslist.component.LocationViewItem

class ScreenNavigator(private val screenNavigatorListener: ScreenNavigatorListener) : BaseScreenNavigator {
    override fun toDetailScreen(locationViewItem: LocationViewItem) {
        screenNavigatorListener.openDetailScreen(locationViewItem)
    }

    override fun toLastScreen() {
        screenNavigatorListener.backToLastScreen()
    }
}