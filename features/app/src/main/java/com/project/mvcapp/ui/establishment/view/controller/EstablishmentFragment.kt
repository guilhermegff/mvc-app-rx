package com.project.mvcapp.ui.establishment.view.controller

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.project.mvcapp.core.BaseFragment
import com.project.mvcapp.core.ScreenNavigatorListener
import com.project.mvcapp.core.factories.AdapterFactory
import com.project.mvcapp.core.factories.AppProvider
import com.project.mvcapp.core.factories.ControllerFactory

class EstablishmentFragment : BaseFragment<EstablishmentViewContract, EstablishmentController, AppProvider, ControllerFactory>() {

    companion object {
        private const val EXTRA_ESTABLISHMENT_ID = "EXTRA_ESTABLISHMENT_ID"

        fun newInstance(id: String) : EstablishmentFragment {
            return EstablishmentFragment().apply {
                arguments = Bundle().apply {
                    this.putString(EXTRA_ESTABLISHMENT_ID, id)
                }
            }
        }
    }

    private lateinit var id: String

    private val listener by lazy {
        when(requireActivity() is ScreenNavigatorListener) {
            true -> requireActivity() as ScreenNavigatorListener
            false -> throw NotImplementedError("${this.requireActivity().localClassName} Must implement ${ScreenNavigatorListener::class.java}.")
        }
    }

    override val appProvider by lazy { AppProvider(requireActivity() as AppCompatActivity, listener) }

    private val adapterFactory by lazy { AdapterFactory(appProvider.adapterViewFactory) }

    override val viewContract by lazy {
        appProvider.screenViewFactory.provideEstablishmentScreenView(
            view?.parent as ViewGroup?,
            adapterFactory.providePicturesAdapter(),
            adapterFactory.provideReviewsAdapter()
        )
    }

    override val controllerFactory by lazy { ControllerFactory(appProvider) }

    override val controller by lazy { controllerFactory.provideEstablishmentController(id)}

    override fun initData() {
        id = arguments?.getString(EXTRA_ESTABLISHMENT_ID)!!
    }
}