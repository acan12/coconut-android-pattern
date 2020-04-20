package com.demo.bee.ui.component.manager

import android.content.Context
import android.widget.TextView
import android.widget.Toast
import com.demo.bee.ui.component.IAction
import com.demo.bee.ui.component.IListener

class ListenerManager : IListener {
    override fun textChangeListener(context: Context) {
        Toast.makeText(context, "Load Listener", Toast.LENGTH_LONG).show()
    }

}