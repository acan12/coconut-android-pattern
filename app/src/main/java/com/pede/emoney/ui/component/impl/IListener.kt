package com.pede.emoney.ui.component.impl

import android.content.Context
import android.widget.Button
import android.widget.EditText
import com.pede.emoney.model.api.request.SignInRequestModel
import com.pede.emoney.ui.impl.ISigninView

interface IListener {

    fun onSigninNavigationListener(
        buttons: Array<Button>,
        context: Context
    )


    fun onSigninActionListener(
        button: Button,
        request: SignInRequestModel?,
        context: Context
    ): IListener

    fun onSigninWatcherListener(edits: Array<EditText>, signinView: ISigninView) : IListener
}