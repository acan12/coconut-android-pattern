package com.demo.bee.ui.component.impl

import android.content.Context
import android.widget.TextView

interface IHomeNavigation : IBaseNavigation {

    fun goSecondPage(txt: String, context: Context)

}