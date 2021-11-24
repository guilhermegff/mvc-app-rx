package com.project.service

import com.project.service.model.Establishment
import com.project.service.model.Locations
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("/locations")
    fun locations() : Single<Locations>

    @GET("/locations/{id}")
    fun establishment(@Path("id") id: String) : Single<Establishment>
}