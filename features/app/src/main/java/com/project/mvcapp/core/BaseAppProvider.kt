package com.project.mvcapp.core

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity

abstract class BaseAppProvider(open val activity: AppCompatActivity) {
    private val context by lazy { activity }
    val layoutInflater : LayoutInflater by lazy { LayoutInflater.from(context) }
}