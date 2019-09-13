package com.pede.emoney.ui.component.manager

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.pede.emoney.Pede
import com.pede.emoney.R
import com.pede.emoney.model.api.request.SignInRequestModel
import com.pede.emoney.ui.component.impl.IHomeNavigation
import com.pede.emoney.ui.component.impl.IListener
import com.pede.emoney.ui.impl.ISigninView

class ListenerManager : IListener {
    override fun onSigninWatcherListener(edits: Array<EditText>, signView: ISigninView) {
        for (et in edits) {
            when (et.id) {
                R.id.etNoHandphone ->
                    et.addTextChangedListener(object : TextWatcherHelper() {
                        override fun onTextChanged(
                            s: CharSequence?,
                            start: Int,
                            before: Int,
                            count: Int
                        ) {
                            signView.handlePhoneWatcher()
                        }
                    })

                R.id.etPin ->
                    et.addTextChangedListener(object : TextWatcherHelper() {
                        override fun onTextChanged(
                            s: CharSequence?,
                            start: Int,
                            before: Int,
                            count: Int
                        ) {
                            signView.handlePinWatcher()
                        }
                    })
            }
        }
    }


    override fun onAuthActionListener(
        buttons: Array<Button>,
        request: SignInRequestModel,
        context: Context
    ) {
        for (btn in buttons) {
            btn.setOnClickListener {
                when (btn.id) {
                    R.id.btnSigninAction -> Pede.getAction().signinAction(request, context)
                }
            }
        }
    }

    override fun onAuthListener(
        buttons: Array<Button>,
        context: Context
    ) {
        val homeNavigation = Pede.getNavigationComponent().homeNavigation(Intent())
        for (btn in buttons) {
            btn.setOnClickListener {
                when (btn.id) {
                    R.id.btnSignin -> homeNavigation.goSignIn(context)
                    R.id.btnSignup -> homeNavigation.goSignUp(context)
                }
            }
        }
    }


    open class TextWatcherHelper : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    }

}