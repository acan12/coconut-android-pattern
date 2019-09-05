package com.pede.emoney.ui.component

import android.content.Context
import android.widget.TextView

interface IAction {
    fun setupAction(context: Context)

    fun showLabelManager(label: String, labelTextView: TextView, context: Context)

    fun getFirebaseToken(context: Context): String

    fun isLatestVersion(currentVersion: String, latestVersion: String): Boolean
}