package com.demo.insurance_feature.ui.activity

import android.os.Bundle
import app.beelabs.com.codebase.base.BaseActivity
import com.demo.insurance_feature.R
import kotlinx.android.synthetic.main.activity_insurance_home.*

class InsuranceHomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insurance_home)

        val value = intent.getIntExtra("data", 0)
        insuranceValue.text = value.toString()
    }
}