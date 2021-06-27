package com.project.hotmartapp

import com.project.hotmartservice.HotMartDataSource
import com.project.hotmartservice.model.Locations
import io.reactivex.Single
import io.reactivex.SingleObserver

class StubApi : HotMartDataSource {

    override fun locations(): Single<Locations> = SingleImpl().map { Locations(arrayListOf()) }

    inner class SingleImpl : Single<Locations>() {
        override fun subscribeActual(observer: SingleObserver<in Locations>) {}
    }
}