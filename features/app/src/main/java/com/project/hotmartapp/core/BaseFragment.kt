package com.project.hotmartapp.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment<VIEW_CONTRACT : RootViewContract, CONTROLLER : BaseController<VIEW_CONTRACT>,
        APP_PROVIDER : BaseAppProvider, CONTROLLER_FACTORY> : Fragment()  {

    protected abstract  val viewContract : VIEW_CONTRACT
    protected abstract  val controller : CONTROLLER

    abstract val appProvider : APP_PROVIDER
    abstract val controllerFactory : CONTROLLER_FACTORY

    abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        controller.registerListener(viewContract)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return viewContract.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controller.initViews()
    }

    override fun onStart() {
        super.onStart()
        controller.onStart()
    }

    override fun onStop() {
        super.onStop()
        controller.onStop()
    }
}