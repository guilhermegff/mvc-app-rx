package com.project.service

import com.project.service.model.Establishment
import com.project.service.model.Locations
import io.reactivex.Single

interface DataSource {
    fun locations() : Single<Locations>
    fun establishment(id: String): Single<Establishment>
}