package com.project.hotmartservice

import com.project.hotmartservice.model.Establishment
import com.project.hotmartservice.model.Locations
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface HotMartService {
    @GET("/locations")
    fun locations() : Single<Locations>

    @GET("/locations/{id}")
    fun establishment(@Path("id") id: String) : Single<Establishment>
}