package com.pede.emoney.ui.component

import android.content.Context
import android.widget.TextView
import com.pede.emoney.ui.component.ILogic

interface IEvent {
    fun setupEvent(context: Context)

    fun showLabelManager(label: String, labelTextView: TextView, context: Context)
}