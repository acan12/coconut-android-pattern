package com.demo.bee.ui.component.manager

import android.content.Context
import android.widget.TextView
import android.widget.Toast
import com.demo.bee.ui.component.IAction

class ActionManager : IAction {
    override fun generalAction(context: Context) {
        Toast.makeText(context, "Show Event", Toast.LENGTH_SHORT).show()
    }

    override fun showLabelManager(label: String, labelTextView: TextView, context: Context) {
        labelTextView.text = label
    }
}