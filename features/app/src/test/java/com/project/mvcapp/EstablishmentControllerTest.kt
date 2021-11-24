package com.project.mvcapp

import com.nhaarman.mockitokotlin2.*
import com.project.mvcapp.ui.establishment.component.reviews.ReviewViewItem
import com.project.mvcapp.ui.establishment.ext.toEstablishmentViewItem
import com.project.mvcapp.ui.establishment.usecase.BaseEstablishmentUseCase
import com.project.mvcapp.ui.establishment.view.controller.EstablishmentController
import com.project.mvcapp.ui.establishment.view.controller.EstablishmentViewContract
import com.project.service.model.Establishment
import com.project.service.model.Week
import com.project.service.model.WorkDay
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class EstablishmentControllerTest {

    companion object {

        private val stubSchedulerProvider = StubSchedulerProvider()

        private lateinit var viewContract : EstablishmentViewContract
        private lateinit var viewContractForFailure : EstablishmentViewContract

        private val establishmentViewItem = Establishment(
            "", 0.0, "", 0, "", Week(
                WorkDay(0, "", "", ""), null, null, null, null, null,
                null), "", "Street, disctrict, number, city, state").toEstablishmentViewItem()

        private val screenNavigator = mock<StubScreenNavigator>()

        private lateinit var successEstablishmentListUseCase : BaseEstablishmentUseCase
        private lateinit var failureEstablishmentListUseCase : BaseEstablishmentUseCase
        private lateinit var controller : EstablishmentController
        private lateinit var failureController : EstablishmentController

        @BeforeClass
        @JvmStatic
        fun setup() {
            successEstablishmentListUseCase = SuccessStubUseCase()
            failureEstablishmentListUseCase = FailureStubUseCase()

            //ObserveLive runs on controller creation and calls loadEstablishment()
            controller = EstablishmentController(successEstablishmentListUseCase, stubSchedulerProvider, "", screenNavigator)
            failureController= EstablishmentController(failureEstablishmentListUseCase, stubSchedulerProvider, "", screenNavigator)
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
    fun toLastScreen_onToolbarBackButtonClick_calledOnce() {
        controller.onBackButtonClick()
        verify(screenNavigator, times(1)).toLastScreen()
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
    fun showEstablishment_onSuccessLoadEstablishment_callsOnce() {
        verify(viewContract, times(1)).showEstablishment(establishmentViewItem)
    }

    @Test
    fun showContacts_onSuccessLoadEstablishment_callsOnce() {
        verify(viewContract, times(1)).showContacts(establishmentViewItem)
    }

    @Test
    fun showSchedule_onSuccessLoadEstablishment_callsOnce() {
        verify(viewContract, times(1)).showSchedule(establishmentViewItem)
    }

    @Test
    fun showReviews_onSuccessLoadEstablishment_callsOnce() {
        val captor = argumentCaptor<ArrayList<ReviewViewItem>>()
        verify(viewContract, times(1)).showReviews(captor.capture())
    }

    @Test
    fun showReviewsCount_onSuccessLoadEstablishment_callsOnce() {
        val captor = argumentCaptor<Int>()
        verify(viewContract, times(1)).showReviewsCount(captor.capture())
    }

    @Test
    fun showPictures_onSuccessLoadEstablishment_callsOnce() {
        verify(viewContract, times(1)).showPictures()
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
    fun showError_onFailureLoadEstablishment_callsOnce() {
        verify(viewContractForFailure, times(1)).showError()
    }

    @Test
    fun retryWithFailure_onErrorViewClick_callsShowErrorTwice() {
        failureController.onErrorViewClick()
        verify(viewContractForFailure, times(2)).showError()
    }

    @Test
    fun retryWithSuccess_onErrorViewClick_callsShowEstablishmentTwice() {
        controller.onErrorViewClick()
        verify(viewContract, times(2)).showEstablishment(establishmentViewItem)
    }

    @Test
    fun retryWithSuccess_onErrorViewClick_callsShowContactsTwice() {
        controller.onErrorViewClick()
        verify(viewContract, times(2)).showContacts(establishmentViewItem)
    }

    @Test
    fun retryWithSuccess_onErrorViewClick_callsShowScheduleTwice() {
        controller.onErrorViewClick()
        verify(viewContract, times(2)).showSchedule(establishmentViewItem)
    }

    @Test
    fun retryWithSuccess_onErrorViewClick_callsShowReviewsTwice() {
        val captor = argumentCaptor<ArrayList<ReviewViewItem>>()
        controller.onErrorViewClick()
        verify(viewContract, times(2)).showReviews(captor.capture())
    }

    @Test
    fun retryWithSuccess_onErrorViewClick_callsShowReviewsCountTwice() {
        val captor = argumentCaptor<Int>()
        controller.onErrorViewClick()
        verify(viewContract, times(2)).showReviewsCount(captor.capture())
    }

    @Test
    fun retryWithSuccess_onErrorViewClick_callsShowPicturesTwice() {
        controller.onErrorViewClick()
        verify(viewContract, times(2)).showPictures()
    }
}