package com.project.hotmartapp.core

import com.project.hotmartapp.R
import com.project.hotmartapp.core.locationslist.view.controller.LocationsListFragment

class MainActivity : BaseActivity(), FragmentLayoutProvider {

    private val locationsListFragment by lazy { LocationsListFragment.newInstance() }

    override fun fragmentFrame() = R.id.contentView

    override fun initViews() { setContentView(R.layout.activity_main) }

    override fun onResume() {
        super.onResume()
        supportFragmentManager.beginTransaction().apply {
            replace(fragmentFrame(), locationsListFragment, locationsListFragment.javaClass.simpleName)
            setPrimaryNavigationFragment(locationsListFragment)
            addToBackStack(locationsListFragment.javaClass.simpleName)
        }.commitAllowingStateLoss()
    }
}