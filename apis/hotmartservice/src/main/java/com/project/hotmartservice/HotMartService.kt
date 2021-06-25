package com.project.hotmartservice

import com.project.hotmartservice.model.Locations
import io.reactivex.Single
import retrofit2.http.GET

interface HotMartService {
    @GET("/locations")
    fun locations() : Single<Locations>
}