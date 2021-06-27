package com.project.hotmartapp

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.project.hotmartapp.ui.locationslist.component.LocationViewItem
import com.project.hotmartapp.ui.locationslist.usecase.BaseLocationsListUseCase
import com.project.hotmartapp.ui.locationslist.view.controller.LocationsListController
import com.project.hotmartapp.ui.locationslist.view.controller.LocationsListViewContract
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class LocationsListControllerTest {

    companion object {

        private val stubSchedulerProvider = StubSchedulerProvider()
        private val locationViewItem = LocationViewItem(0, "", "", "", 0.0, "")

        private lateinit var viewContract : LocationsListViewContract
        private lateinit var viewContractForFailure : LocationsListViewContract
        private val screenNavigator = mock<StubScreenNavigator>()

        private lateinit var successLocationsListUseCase : BaseLocationsListUseCase
        private lateinit var failureLocationsListUseCase : BaseLocationsListUseCase
        private lateinit var controller : LocationsListController
        private lateinit var failureController : LocationsListController

        @BeforeClass
        @JvmStatic
        fun setup() {
            successLocationsListUseCase = SuccessStubUseCase()
            failureLocationsListUseCase = FailureStubUseCase()

            //ObserveLive runs on controller creation and calls loadLocations()
            controller = LocationsListController(successLocationsListUseCase, stubSchedulerProvider, screenNavigator)
            failureController= LocationsListController(failureLocationsListUseCase, stubSchedulerProvider, screenNavigator)
        }
    }

    @Before
    fun createViewMocks() {
        viewContract = mock()
        viewContractForFailure = mock()
    }

    @Before
    fun registerMocks() {
        controller.registerListener(viewContract)
        failureController.registerListener(viewContractForFailure)
    }

    @Test
    fun registerListener_onControllerCreation_calledOnce() {
        verify(viewContract, times(1)).registerListener(controller)
    }

    @Test
    fun registerListener_onControllerStart_calledTwoTimes() {
        //First call is made just after controller instance creation in fun setup()
        controller.onStart()
        verify(viewContract, times(2)).registerListener(controller)
    }

    @Test
    fun unregisterListener_onControllerStop_calledOnce() {
        controller.onStop()
        verify(viewContract, times(1)).unregisterListener(controller)
    }

    @Test
    fun toDetailScreen_onItemClick_calledOnce() {
        controller.onLocationClick(locationViewItem)
        verify(screenNavigator, times(1)).toDetailScreen(locationViewItem)
    }

    @Test
    fun showLoading_onSubscriptionWithSuccessUseCase_callsOnce() {
        verify(viewContract, times(1)).showLoading()
    }

    @Test
    fun hideLoading_onFinallyWithSuccessUseCase_callsOnce() {
        verify(viewContract, times(1)).hideLoading()
    }

    @Test
    fun showLocations_onSuccessLoadLocations_callsOnce() {
        verify(viewContract, times(1)).showLocations(arrayListOf())
    }

    @Test
    fun showLoading_onSubscriptionWithFailureUseCase_callsOnce() {
        verify(viewContractForFailure, times(1)).showLoading()
    }

    @Test
    fun hideLoading_onFinallyWithFailureUseCase_callsOnce() {
        verify(viewContractForFailure, times(1)).hideLoading()
    }

    @Test
    fun showError_onFailureLoadLocations_callsOnce() {
        verify(viewContractForFailure, times(1)).showError()
    }

    @Test
    fun retryWithFailure_onErrorViewClick_callsShowError() {
        failureController.onErrorViewClick()
        verify(viewContractForFailure, times(2)).showError()
    }

    @Test
    fun retryWithSuccess_onErrorViewClick_callsShowLocations() {
        controller.onErrorViewClick()
        verify(viewContract, times(2)).showLocations(arrayListOf())
    }
}