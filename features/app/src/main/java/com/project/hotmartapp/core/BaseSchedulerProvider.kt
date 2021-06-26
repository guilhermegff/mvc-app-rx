package com.project.hotmartapp.core

import io.reactivex.Scheduler

interface BaseSchedulerProvider {
    fun io(): Scheduler
    fun ui(): Scheduler
}