package com.project.hotmartapp

import com.project.hotmartapp.core.BaseScreenNavigator
import com.project.hotmartapp.ui.locationslist.component.LocationViewItem

open class StubScreenNavigator : BaseScreenNavigator {
    override fun toDetailScreen(locationViewItem: LocationViewItem) {}
    override fun toLastScreen() {}
}