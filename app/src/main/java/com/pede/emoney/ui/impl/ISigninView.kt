package com.pede.emoney.ui.impl

import app.beelabs.com.codebase.base.IView

interface ISigninView : IView {

    fun handlePhoneWatcher()
    fun handlePinWatcher()
}