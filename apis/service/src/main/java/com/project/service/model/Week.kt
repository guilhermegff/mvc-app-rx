package com.project.service.model

import com.google.gson.annotations.SerializedName

data class Week(
    @SerializedName("sunday")
    val sunday: WorkDay?,
    @SerializedName("monday")
    val monday: WorkDay?,
    @SerializedName("tuesday")
    val tuesday: WorkDay?,
    @SerializedName("wednesday")
    val wednesday: WorkDay?,
    @SerializedName("thursday")
    val thursday: WorkDay?,
    @SerializedName("friday")
    val friday: WorkDay?,
    @SerializedName("saturday")
    val saturday: WorkDay?
)