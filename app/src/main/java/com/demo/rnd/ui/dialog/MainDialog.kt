package com.demo.rnd.ui.dialog

import android.content.Context
import android.os.Bundle
import com.demo.rnd.R
import app.beelabs.com.codebase.base.BaseDialog

class MainDialog(context: Context, style: Int) : BaseDialog(context, style) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_main)
    }
}