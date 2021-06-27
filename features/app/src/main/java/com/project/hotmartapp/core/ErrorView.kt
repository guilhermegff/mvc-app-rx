package com.project.hotmartapp.core

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.project.hotmartapp.R
import com.project.hotmartapp.core.ext.rotate

class ErrorView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                          defStyleAttr: Int = 0,
                                          var errorViewListener: ErrorViewListener? = null)
    : ConstraintLayout(context, attrs, defStyleAttr) {

    private val refreshView : ImageView by lazy { rootView.findViewById(R.id.refreshView) }

        init {
            LayoutInflater.from(context).inflate(R.layout.error_view, this, true)
            refreshView.rotate()
            setRefreshAction()
        }

    private fun setRefreshAction() {
        refreshView.setOnClickListener {
            refreshView.rotate()
            errorViewListener?.doAction()
            errorViewListener = null
        }
    }
}