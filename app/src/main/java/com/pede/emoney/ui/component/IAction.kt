package com.pede.emoney.ui.component

import android.app.Activity
import android.content.Context
import android.widget.Button
import android.widget.TextView
import com.pede.emoney.model.api.request.SignInRequestModel

interface IAction {
    fun validateSignInForm(phone: String, pin: String, target: Button, activity: Activity): Boolean

    fun signinAction(request: SignInRequestModel, context: Context)

    fun setupAction(context: Context)

    fun showLabelManager(label: String, labelTextView: TextView, context: Context)

    fun putFirebaseTokenToSession(context: Context)

    fun isLatestVersion(currentVersion: String, latestVersion: String): Boolean

}