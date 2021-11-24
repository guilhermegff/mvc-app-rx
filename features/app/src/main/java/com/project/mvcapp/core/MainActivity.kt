package com.project.mvcapp.core

import com.project.mvcapp.R
import com.project.mvcapp.ui.establishment.view.controller.EstablishmentFragment
import com.project.mvcapp.ui.locationslist.component.LocationViewItem
import com.project.mvcapp.ui.locationslist.view.controller.LocationsListFragment

class MainActivity : BaseActivity(), FragmentLayoutProvider, ScreenNavigatorListener {

    override fun fragmentFrame() = R.id.contentView

    override fun initViews() { setContentView(R.layout.activity_main) }

    override fun onResume() {
        super.onResume()
        val locationsListFragment = LocationsListFragment.newInstance()
        supportFragmentManager.beginTransaction().apply {
            replace(fragmentFrame(), locationsListFragment, locationsListFragment.javaClass.simpleName)
            setPrimaryNavigationFragment(locationsListFragment)
        }.commitAllowingStateLoss()
    }

    override fun openDetailScreen(locationViewItem: LocationViewItem) {
        val establishmentFragment = EstablishmentFragment.newInstance(locationViewItem.id.toString())
        supportFragmentManager.beginTransaction().apply {
            replace(fragmentFrame(), establishmentFragment, establishmentFragment.javaClass.simpleName)
            setPrimaryNavigationFragment(establishmentFragment)
            addToBackStack(establishmentFragment.javaClass.simpleName)
        }.commitAllowingStateLoss()
    }

    override fun backToLastScreen() {
        super.onBackPressed()
    }
}