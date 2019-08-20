package com.pede.emoney.ui.activity

import android.os.Bundle
import app.beelabs.com.codebase.base.BaseActivity
import com.pede.emoney.IConfig
import com.pede.emoney.R
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