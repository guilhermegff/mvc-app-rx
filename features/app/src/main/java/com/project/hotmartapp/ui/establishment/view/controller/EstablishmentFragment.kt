package com.project.hotmartapp.ui.establishment.view.controller

import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.project.hotmartapp.core.BaseFragment
import com.project.hotmartapp.core.ScreenNavigatorListener
import com.project.hotmartapp.core.factories.AdapterFactory
import com.project.hotmartapp.core.factories.AppProvider
import com.project.hotmartapp.core.factories.ControllerFactory

class EstablishmentFragment : BaseFragment<EstablishmentViewContract, EstablishmentController, AppProvider, ControllerFactory>() {

    companion object {
        fun newInstance() = EstablishmentFragment()
    }

    private val listener by lazy {
        when(requireActivity() is ScreenNavigatorListener) {
            true -> requireActivity() as ScreenNavigatorListener
            false -> throw NotImplementedError("${this.requireActivity().localClassName} Must implement ${ScreenNavigatorListener::class.java}.")
        }
    }

    override val appProvider by lazy { AppProvider(requireActivity() as AppCompatActivity, listener) }

    private val adapterFactory by lazy { AdapterFactory(appProvider.adapterViewFactory) }

    override val viewContract by lazy { appProvider.screenViewFactory.provideEstablishmentScreenView(view?.parent as ViewGroup?) }

    override val controllerFactory by lazy { ControllerFactory(appProvider) }

    override val controller by lazy { controllerFactory.provideEstablishmentController()}

    override fun initData() {
        //TODO("Not yet implemented")
    }
}