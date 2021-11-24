package com.project.mvcapp.ui.locationslist.component

data class LocationViewItem(
    val id: Int,
    val image: String,
    val name: String,
    val type: String,
    val rating: Double,
    val review: String
)