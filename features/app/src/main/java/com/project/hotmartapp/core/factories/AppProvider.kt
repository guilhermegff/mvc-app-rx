package com.project.hotmartapp.core.factories

import androidx.appcompat.app.AppCompatActivity
import com.project.hotmartapp.core.BaseAppProvider
import com.project.hotmartapp.core.SchedulerProvider
import com.project.hotmartapp.core.ScreenNavigator
import com.project.hotmartapp.core.ScreenNavigatorListener

class AppProvider(override val activity: AppCompatActivity, screenNavigatorListener: ScreenNavigatorListener) : BaseAppProvider(activity) {
    val screenViewFactory by lazy { ScreenViewFactory(layoutInflater)}
    val adapterViewFactory by lazy { AdapterViewFactory(layoutInflater)}
    val useCaseFactory by lazy { UseCaseFactory() }
    val screenNavigator by lazy { ScreenNavigator(screenNavigatorListener)}
    val schedulerProvider by lazy { SchedulerProvider() }
}