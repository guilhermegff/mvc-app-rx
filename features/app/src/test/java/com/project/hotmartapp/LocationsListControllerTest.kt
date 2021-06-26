package com.project.hotmartapp

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.project.hotmartapp.ui.locationslist.usecase.LocationsListUseCase
import com.project.hotmartapp.ui.locationslist.view.controller.LocationsListController
import com.project.hotmartapp.ui.locationslist.view.controller.LocationsListViewContract

import org.junit.Before
import org.junit.Test

class LocationsListControllerTest {

    private val hotMartDataSource = StubApi()

    private val schedulerProvider = StubSchedulerProvider()

    private val viewContract = mock<LocationsListViewContract>()

    private lateinit var locationsListUseCase : LocationsListUseCase
    private lateinit var SUT : LocationsListController

    @Before
    fun setup() {
        locationsListUseCase = LocationsListUseCase(hotMartDataSource)
        SUT = LocationsListController(locationsListUseCase, schedulerProvider)
        SUT.registerListener(viewContract)
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
}