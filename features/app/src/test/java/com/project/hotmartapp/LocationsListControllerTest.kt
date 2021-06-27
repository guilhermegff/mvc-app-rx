package com.project.hotmartapp

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.project.hotmartapp.ui.locationslist.component.LocationViewItem
import com.project.hotmartapp.ui.locationslist.usecase.BaseLocationsListUseCase
import com.project.hotmartapp.ui.locationslist.view.controller.LocationsListController
import com.project.hotmartapp.ui.locationslist.view.controller.LocationsListViewContract

import org.junit.BeforeClass
import org.junit.Test

class LocationsListControllerTest {

    companion object {

        private val stubSchedulerProvider = StubSchedulerProvider()
        private val locationViewItem = LocationViewItem(0, "", "", "", 0.0, "")

        private val viewContract = mock<LocationsListViewContract>()
        private val screenNavigator = mock<StubScreenNavigator>()

        private lateinit var locationsListUseCase : BaseLocationsListUseCase
        private lateinit var SUT : LocationsListController

        @BeforeClass
        @JvmStatic
        fun setup() {
            locationsListUseCase = SuccessStubUseCase()
            SUT = LocationsListController(locationsListUseCase, stubSchedulerProvider, screenNavigator)
            SUT.registerListener(viewContract)
        }
    }

    @Test
    fun registerListener_onControllerCreation_calledOnce() {
        verify(viewContract, times(1)).registerListener(SUT)
    }

    @Test
    fun registerListener_onControllerStart_calledTwoTimes() {
        SUT.onStart()
        verify(viewContract, times(2)).registerListener(SUT)
    }

    @Test
    fun unregisterListener_onControllerStop_calledOnce() {
        SUT.onStop()
        verify(viewContract, times(1)).unregisterListener(SUT)
    }

    @Test
    fun toDetailScreen_onItemClick_calledOnce() {
        SUT.onLocationClick(locationViewItem)
        verify(screenNavigator, times(1)).toDetailScreen(locationViewItem)
    }

    @Test
    fun showLocations_onSuccessLoadLocations_callsOnce() {
        //ObserveLive runs on SUT creation
        verify(viewContract, times(1)).showLocations(arrayListOf())
    }

    @Test
    fun showError_onFailureLoadLocations_callsOnce() {
        locationsListUseCase = FailureStubUseCase()
        SUT = LocationsListController(locationsListUseCase, stubSchedulerProvider, screenNavigator)
        SUT.registerListener(viewContract)
        verify(viewContract, times(1)).showError()
    }
}