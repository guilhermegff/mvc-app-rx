package com.project.mvcapp.ui.locationslist.view.controller

import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.project.mvcapp.core.BaseFragment
import com.project.mvcapp.core.ScreenNavigatorListener
import com.project.mvcapp.core.factories.AdapterFactory
import com.project.mvcapp.core.factories.AppProvider
import com.project.mvcapp.core.factories.ControllerFactory

class LocationsListFragment : BaseFragment<LocationsListViewContract, LocationsListController, AppProvider, ControllerFactory>() {

    companion object {
        fun newInstance() = LocationsListFragment()
    }

    private val listener by lazy {
        when(requireActivity() is ScreenNavigatorListener) {
            true -> requireActivity() as ScreenNavigatorListener
            false -> throw NotImplementedError("${this.requireActivity().localClassName} Must implement ${ScreenNavigatorListener::class.java}.")
        }
    }

    override val appProvider by lazy { AppProvider(requireActivity() as AppCompatActivity, listener) }

    private val adapterFactory by lazy { AdapterFactory(appProvider.adapterViewFactory)}

    override val viewContract by lazy { appProvider.screenViewFactory.provideLocationsListScreenView(view?.parent as ViewGroup?, adapterFactory.provideLocationsAdapter()) }

    override val controllerFactory by lazy { ControllerFactory(appProvider) }

    override val controller by lazy { controllerFactory.provideLocationsListController()}

    override fun initData() {
        //TODO("Not yet implemented")
    }
}