package com.demo.bee.ui.component.manager

import android.content.Context
import android.widget.Toast
import com.demo.bee.ui.component.IEvent

class EventManager : IEvent {
    override fun setupEvent(context: Context) {
        Toast.makeText(context, "Show Event", Toast.LENGTH_SHORT).show()
    }
}