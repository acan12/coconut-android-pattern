package com.pede.emoney.ui.component.impl

import android.content.Context
import com.pede.emoney.ui.component.IUi

interface IPaymentUI : IUi {

    fun setupPayment(context: Context)
}