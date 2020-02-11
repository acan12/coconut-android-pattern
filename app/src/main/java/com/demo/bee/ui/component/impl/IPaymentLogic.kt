package com.demo.bee.ui.component.impl

import android.content.Context
import com.demo.bee.ui.component.ILogic

interface IPaymentLogic : ILogic {

    fun setupPayment(context: Context)
}