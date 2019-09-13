package com.pede.emoney.ui.component.manager

import android.content.Context
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import app.beelabs.com.codebase.base.BasePresenter
import app.beelabs.com.codebase.base.IView
import app.beelabs.com.codebase.support.util.CacheUtil
import com.google.firebase.iid.FirebaseInstanceId
import com.pede.emoney.IConfig
import com.pede.emoney.R
import com.pede.emoney.model.api.request.SignInRequestModel
import com.pede.emoney.presenter.AuthPresenter
import com.pede.emoney.ui.component.IAction
import support.FormValidation

class ActionManager : IAction {
    override fun validateSignInForm(phone: String, pin: String, target: Button, context: Context): Boolean {
//        val phone = etPhone.getText().toString()
//        val pin = etPin.getText().toString()

//        if (FormValidation.required(phone) && FormValidation.validPhone(phone)
//            && FormValidation.required(pin) && FormValidation.validPin(pin)
//        ) {
//            isFormValidationSuccess = true
//            target.setBackground(
//                ContextCompat.getDrawable(
//                    context,
//                    R.drawable.button_primary_selector
//                )
//            )
//        } else {
//            isFormValidationSuccess = false
//            target.setBackground(
//                ContextCompat.getDrawable(
//                    context,
//                    R.drawable.button_primary_selected_bg
//                )
//            )
//        }
//
//        if (FormValidation.required(phone) && FormValidation.validPhone(phone)) {
//            linePhoneSignInStatus.setBackgroundColor(
//                ContextCompat.getColor(
//                    context,
//                    R.color.cross_bottom_line
//                )
//            )
//            imgPhoneSignInStatus.setImageDrawable(
//                ContextCompat.getDrawable(
//                    context,
//                    R.mipmap.ic_phone_valid
//                )
//            )
//            imgPhoneSignInStatus.setColorFilter(
//                ContextCompat.getColor(
//                    context,
//                    R.color.cross_bottom_line
//                ), android.graphics.PorterDuff.Mode.SRC_IN
//            )
//        } else {
//            linePhoneSignInStatus.setBackgroundColor(
//                ContextCompat.getColor(
//                    this,
//                    R.color.medium_grey
//                )
//            )
//            imgPhoneSignInStatus.setImageDrawable(
//                ContextCompat.getDrawable(
//                    this,
//                    R.drawable.ic_phone_invalid
//                )
//            )
//            imgPhoneSignInStatus.setColorFilter(
//                ContextCompat.getColor(this, R.color.medium_grey),
//                android.graphics.PorterDuff.Mode.SRC_IN
//            )
//        }
//
//        if (FormValidation.required(pin) && FormValidation.validPin(pin)) {
//            linePinStatus.setBackgroundColor(
//                ContextCompat.getColor(
//                    this,
//                    R.color.cross_bottom_line
//                )
//            )
//            imgPinSignInStatus.setImageDrawable(
//                ContextCompat.getDrawable(
//                    this,
//                    R.drawable.ic_pin_valid
//                )
//            )
//            imgPinSignInStatus.setColorFilter(
//                ContextCompat.getColor(
//                    this,
//                    R.color.cross_bottom_line
//                ), android.graphics.PorterDuff.Mode.SRC_IN
//            )
//        } else {
//            linePinStatus.setBackgroundColor(ContextCompat.getColor(this, R.color.medium_grey))
//            imgPinSignInStatus.setImageDrawable(
//                ContextCompat.getDrawable(
//                    this,
//                    R.drawable.ic_pin_invalid
//                )
//            )
//            imgPinSignInStatus.setColorFilter(
//                ContextCompat.getColor(this, R.color.medium_grey),
//                android.graphics.PorterDuff.Mode.SRC_IN
//            )
//        }

        return true
    }

    override fun signinAction(request: SignInRequestModel, context: Context) {
        (BasePresenter.getInstance(
            context as IView,
            AuthPresenter::class.java
        ) as AuthPresenter).signIn(request)
    }


    override fun putFirebaseTokenToSession(context: Context) {
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener { task ->
                if (task.isSuccessful) CacheUtil.putPreferenceString(
                    IConfig.SESSION_FIREBASE_TOKEN,
                    task.result?.token,
                    context
                )
                else Log.w("", "getInstanceId failed", task.exception)
            }
    }

    override fun isLatestVersion(currentVersion: String, latestVersion: String): Boolean {
        val currentVersionSplit =
            currentVersion.split("[\\.]".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val latestVersionSplit =
            latestVersion.split("[\\.]".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        for (i in currentVersionSplit.indices) {
            if (Integer.valueOf(currentVersionSplit[i]) < Integer.valueOf(latestVersionSplit[i])) {
                return false
            }
        }

        return true
    }

    override fun showLabelManager(label: String, labelTextView: TextView, context: Context) {
        labelTextView.text = label
    }

    override fun setupAction(context: Context) {
        Toast.makeText(context, "Show Event", Toast.LENGTH_SHORT).show()
    }
}