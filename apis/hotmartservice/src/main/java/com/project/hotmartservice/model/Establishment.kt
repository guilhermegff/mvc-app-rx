package com.project.hotmartservice.model

import com.google.gson.annotations.SerializedName

data class Establishment(
    val name: String,
    @SerializedName("review")
    val rating: Double,
    val type: String,
    val id: Int,
    val about: String,
    val schedule: Week,
    val phone: String,
    val adress: String
)