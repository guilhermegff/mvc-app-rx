package com.project.hotmartapp.core

import com.project.hotmartapp.R

class MainActivity : BaseActivity(), FragmentLayoutProvider {

    override fun fragmentFrame() = R.id.contentView

    override fun initViews() { setContentView(R.layout.activity_main) }
}