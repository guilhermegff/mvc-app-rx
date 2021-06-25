package com.project.hotmartservice.model

import com.google.gson.annotations.SerializedName

data class Locations(
    @SerializedName("listLocations")
    val collection: List<Location>)