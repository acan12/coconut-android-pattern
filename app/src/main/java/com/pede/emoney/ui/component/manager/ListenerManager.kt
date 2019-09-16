package com.pede.emoney.ui.component.manager

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import com.pede.emoney.Pede
import com.pede.emoney.R
import com.pede.emoney.model.api.request.SignInRequestModel
import com.pede.emoney.ui.component.impl.IListener
import com.pede.emoney.ui.impl.ISigninView

class ListenerManager : IListener {
    override fun onSigninWatcherListener(
        edits: Array<EditText>,
        signinView: ISigninView
    ): IListener {
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
                            signinView.handlePhoneWatcher()
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
                            signinView.handlePinWatcher()
                        }
                    })
            }
        }

        return this
    }


    override fun onSigninActionListener(
        button: Button,
        helper: Helper??,
        context: Context
    ): IListener {
        button.setOnClickListener {
            when (button.id) {
                R.id.btnSigninAction -> {
                    var request = helper!!.callback() as SignInRequestModel
                    Pede.getAction().signinAction(request, context)
                }

            }
        }

        return this
    }

    override fun onSigninNavigationListener(
        buttons: Array<Button>,
        context: Context
    ) {
        val homeNavigation = Pede.getNavigationComponent().homeNavigation(Intent())
        for (button in buttons) {
            button.setOnClickListener {
                when (button.id) {
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

    open class Helper {

        open fun callback(): Object? {
            return null
        }
    }
}