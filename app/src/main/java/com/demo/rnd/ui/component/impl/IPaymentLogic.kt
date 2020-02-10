package com.demo.rnd.ui.component.impl

import android.content.Context
import com.demo.rnd.ui.component.ILogic

interface IPaymentLogic : ILogic {

    fun setupPayment(context: Context)
}