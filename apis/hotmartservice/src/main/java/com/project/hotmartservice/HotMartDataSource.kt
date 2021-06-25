package com.project.hotmartservice

import com.project.hotmartservice.model.Locations
import io.reactivex.Single

interface HotMartDataSource {
    fun locations() : Single<Locations>
}