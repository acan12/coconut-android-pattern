package com.pede.emoney.ui

import app.beelabs.com.codebase.base.IView
import com.pede.emoney.model.api.response.CheckVersionResponseModel
import com.pede.emoney.model.api.response.SignInResponseModel
import com.pede.emoney.model.api.response.SignUpResponseModel

interface IAuthView : IView {
//    fun handleSignupResponse(model: SignUpResponseModel)
//    fun handleSigninResponse(model: SignInResponseModel)
    fun handleCheckVersion(model: CheckVersionResponseModel)
}