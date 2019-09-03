package com.pede.emoney.ui.impl

import app.beelabs.com.codebase.base.IView
import com.pede.emoney.model.api.response.CheckVersionResponseModel

interface ISplashView : IView {
    fun handleCheckVersion(model: CheckVersionResponseModel)
}