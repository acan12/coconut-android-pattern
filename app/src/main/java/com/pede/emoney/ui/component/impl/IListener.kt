package com.pede.emoney.ui.component.impl

import android.content.Context
import android.widget.Button
import android.widget.EditText
import com.pede.emoney.model.api.request.SignInRequestModel
import com.pede.emoney.ui.impl.ISigninView

interface IListener {

    fun onAuthListener(
        buttons: Array<Button>,
        context: Context
    )


    fun onAuthActionListener(
        buttons: Array<Button>,
        request: SignInRequestModel,
        context: Context
    )

    fun onSigninWatcherListener(edits: Array<EditText>, signinView: ISigninView)
}