package com.project.mvcapp.core.factories

import androidx.appcompat.app.AppCompatActivity
import com.project.mvcapp.core.BaseAppProvider
import com.project.mvcapp.core.SchedulerProvider
import com.project.mvcapp.core.ScreenNavigator
import com.project.mvcapp.core.ScreenNavigatorListener

class AppProvider(override val activity: AppCompatActivity, screenNavigatorListener: ScreenNavigatorListener) : BaseAppProvider(activity) {
    val screenViewFactory by lazy { ScreenViewFactory(layoutInflater)}
    val adapterViewFactory by lazy { AdapterViewFactory(layoutInflater)}
    val useCaseFactory by lazy { UseCaseFactory() }
    val screenNavigator by lazy { ScreenNavigator(screenNavigatorListener)}
    val schedulerProvider by lazy { SchedulerProvider() }
}