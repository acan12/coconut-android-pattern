package com.pede.emoney.ui.component.manager

import android.content.Context
import android.content.Intent
import android.widget.TextView
import com.pede.emoney.IConfig
import com.pede.emoney.ui.activity.SecondActivity
import com.pede.emoney.ui.component.impl.IHomeNavigation

class HomeNavigation : IHomeNavigation {
    override fun goSecondPage(txt: String, context: Context) {
        val intent = Intent(context, SecondActivity::class.java)
        intent.putExtra(IConfig.KEY_DATA_SECOND_ACTIVITY, txt)
        context.startActivity(intent)
    }

}