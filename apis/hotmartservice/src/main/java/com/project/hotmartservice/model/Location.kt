package com.project.hotmartservice.model

import com.google.gson.annotations.SerializedName

data class Location(
    val id: Int,
    val name: String,
    @SerializedName("review")
    val rating: Double,
    val type: String
)