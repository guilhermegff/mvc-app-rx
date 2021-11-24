package com.project.mvcapp.core

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

abstract class BaseView(layoutInflater: LayoutInflater, viewGroup: ViewGroup?, @LayoutRes layoutId: Int) : RootViewContract {
    override val rootView: View by lazy { layoutInflater.inflate(layoutId, viewGroup, false) }
    val activity by lazy { rootView.context as Activity }
}