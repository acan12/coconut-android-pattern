package com.demo.bee.ui.component.manager

import android.content.Context
import android.content.Intent
import android.widget.TextView
import com.demo.bee.IConfig
import com.demo.bee.ui.activity.SecondActivity
import com.demo.bee.ui.component.impl.IHomeNavigation

class HomeNavigation : IHomeNavigation {
    override fun goSecondPage(txt: String, context: Context) {
        val intent = Intent(context, SecondActivity::class.java)
        intent.putExtra(IConfig.KEY_DATA_SECOND_ACTIVITY, txt)
        context.startActivity(intent)
    }

    override fun showLabelManager(label: String, labelTextView: TextView, context: Context) {
        labelTextView.text = label
    }

}