package com.project.hotmartapp.core.factories

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import com.project.hotmartapp.core.BaseAppProvider
import com.project.hotmartapp.core.SchedulerProvider

class AppProvider(override val activity: AppCompatActivity, @IdRes frameId: Int) : BaseAppProvider(activity) {
    val screenViewFactory by lazy { ScreenViewFactory(layoutInflater)}
    val adapterViewFactory by lazy { AdapterViewFactory(layoutInflater)}
    val useCaseFactory by lazy { UseCaseFactory() }
    val schedulerProvider by lazy { SchedulerProvider() }
}