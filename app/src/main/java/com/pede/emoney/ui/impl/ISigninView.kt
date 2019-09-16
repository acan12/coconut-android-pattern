package com.pede.emoney.ui.impl

import app.beelabs.com.codebase.base.IView
import com.pede.emoney.model.api.response.SignInResponseModel

interface ISigninView : IView {

    fun handlePhoneWatcher()
    fun handlePinWatcher()

    fun handleApiSignin(response: SignInResponseModel)
}