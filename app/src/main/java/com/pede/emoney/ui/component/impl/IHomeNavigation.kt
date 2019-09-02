package com.pede.emoney.ui.component.impl

import android.content.Context
import android.content.Intent
import android.widget.TextView

interface IHomeNavigation : IBaseNavigation {

    fun goSecondPage(txt: String, context: Context)
}