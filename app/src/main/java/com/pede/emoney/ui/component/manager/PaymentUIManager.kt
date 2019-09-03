package com.pede.emoney.ui.component.manager

import android.content.Context
import android.widget.Toast
import com.pede.emoney.ui.component.impl.IPaymentUI

class PaymentUIManager : IPaymentUI {

    override fun setupPayment(context: Context) {
        Toast.makeText(context, "Show Payment logic", Toast.LENGTH_SHORT).show()
    }
}