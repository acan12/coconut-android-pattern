package com.demo.bee.ui.activity

import android.os.Bundle
import app.beelabs.com.codebase.base.BaseActivity
import com.demo.bee.IConfig
import com.demo.bee.R
import kotlinx.android.synthetic.main.activity_second.*

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class SecondActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        
        var label = intent.extras.getString(IConfig.KEY_DATA_SECOND_ACTIVITY)
        labelSecondText.text = label!!

    }
}