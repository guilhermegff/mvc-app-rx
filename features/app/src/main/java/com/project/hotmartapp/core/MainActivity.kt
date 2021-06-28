package com.project.hotmartapp.core

import android.widget.Toast
import com.project.hotmartapp.R
import com.project.hotmartapp.ui.establishment.view.controller.EstablishmentFragment
import com.project.hotmartapp.ui.locationslist.component.LocationViewItem
import com.project.hotmartapp.ui.locationslist.view.controller.LocationsListFragment

class MainActivity : BaseActivity(), FragmentLayoutProvider, ScreenNavigatorListener {

    private val locationsListFragment by lazy { LocationsListFragment.newInstance() }
    private val establishmentFragment by lazy { EstablishmentFragment.newInstance() }

    override fun fragmentFrame() = R.id.contentView

    override fun initViews() { setContentView(R.layout.activity_main) }

    override fun onResume() {
        super.onResume()
        supportFragmentManager.beginTransaction().apply {
            replace(fragmentFrame(), locationsListFragment, locationsListFragment.javaClass.simpleName)
            setPrimaryNavigationFragment(locationsListFragment)
        }.commitAllowingStateLoss()
    }

    override fun openDetailScreen(locationViewItem: LocationViewItem) {
        supportFragmentManager.beginTransaction().apply {
            replace(fragmentFrame(), establishmentFragment, establishmentFragment.javaClass.simpleName)
            setPrimaryNavigationFragment(establishmentFragment)
            addToBackStack(establishmentFragment.javaClass.simpleName)
        }.commitAllowingStateLoss()
    }
}