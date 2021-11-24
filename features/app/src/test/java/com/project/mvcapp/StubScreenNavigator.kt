package com.project.mvcapp

import com.project.mvcapp.core.BaseScreenNavigator
import com.project.mvcapp.ui.locationslist.component.LocationViewItem

open class StubScreenNavigator : BaseScreenNavigator {
    override fun toDetailScreen(locationViewItem: LocationViewItem) {}
    override fun toLastScreen() {}
}