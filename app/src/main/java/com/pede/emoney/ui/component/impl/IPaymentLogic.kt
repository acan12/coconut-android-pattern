package com.pede.emoney.ui.component.impl

import android.content.Context
import com.pede.emoney.ui.component.ILogic

interface IPaymentLogic : ILogic {

    fun setupPayment(context: Context)
}