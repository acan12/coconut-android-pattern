package com.pede.emoney.ui.impl

import app.beelabs.com.codebase.base.IView
import com.pede.emoney.model.api.response.SignInResponseModel
import com.pede.emoney.model.api.response.SignUpResponseModel

interface IAuthView : IView {
    fun handleSignupResponse(model: SignUpResponseModel)
    fun handleSigninResponse(model: SignInResponseModel)

}