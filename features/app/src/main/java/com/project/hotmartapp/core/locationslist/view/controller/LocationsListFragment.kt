package com.project.hotmartapp.core.locationslist.view.controller

import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.project.hotmartapp.core.BaseFragment
import com.project.hotmartapp.core.FragmentLayoutProvider
import com.project.hotmartapp.core.factories.AdapterFactory
import com.project.hotmartapp.core.factories.AppProvider
import com.project.hotmartapp.core.factories.ControllerFactory

class LocationsListFragment : BaseFragment<LocationsListViewContract, LocationsListController, AppProvider, ControllerFactory>() {

    companion object {
        fun newInstance() = LocationsListFragment()
    }

    override val appProvider by lazy { AppProvider(requireActivity() as AppCompatActivity, (requireActivity() as FragmentLayoutProvider).fragmentFrame()) }

    private val adapterFactory by lazy { AdapterFactory(appProvider.adapterViewFactory) }

    override val viewContract by lazy { appProvider.screenViewFactory.provideLocationsListScreenView(view?.parent as ViewGroup?) }

    override val controllerFactory by lazy { ControllerFactory(appProvider) }

    override val controller by lazy { controllerFactory.provideLocationsListController()}

    override fun initData() {
        //TODO("Not yet implemented")
    }
}