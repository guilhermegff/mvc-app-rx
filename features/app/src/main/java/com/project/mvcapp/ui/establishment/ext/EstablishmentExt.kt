package com.project.mvcapp.ui.establishment.ext

import com.project.mvcapp.ui.establishment.component.establishment.EstablishmentViewItem
import com.project.service.model.Establishment

fun Establishment.toEstablishmentViewItem() = EstablishmentViewItem(
    name, rating, about, schedule, formatPhone(phone), formatAddress(adress)
)

private fun formatPhone(phone: String): String {
    val minimumLenghtCompletePhone = 13
    return if (phone.isNotEmpty() && phone.length >= minimumLenghtCompletePhone) {
        val secondHalfMaxChars = 4
        val countryCode = phone.substring(0, 3)
        val domesticCode = phone.substring(3, 5)
        phone.substring(5).let {
            val firstHalf = it.substring(0, it.length - secondHalfMaxChars)
            val secondHalf = it.substring(firstHalf.length, it.length)
            "$countryCode $domesticCode $firstHalf $secondHalf"
        }
    } else {
        phone
    }
}

private fun formatAddress(address: String) : String{
    val street = 0
    val number = 1
    val district = 2
    val city = 3
    val state = 4
    return address.split(",").let {
        "${it[street]}, ${it[number]} - ${it[district]} \n${it[city]} - ${it[state]}"
    }
}