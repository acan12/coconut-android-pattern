package com.pede.emoney.ui.activity.splash

import android.content.Intent
import android.os.Bundle
import com.pede.emoney.Pede
import com.pede.emoney.R
import com.pede.emoney.ui.activity.AppActivity
import kotlinx.android.synthetic.main.activity_firsttime_install.*

class FirstTimeInstallActivity : AppActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firsttime_install)

        initView()
    }

    private fun initView() {

        tvVersion.setText(appVersionLabel(this))

        val buttons = arrayOf(btnSignin, btnSignup)
        val homeNav = Pede.getNavigationComponent().homeNavigation(Intent())

        Pede.getListener().onSigninNavigationListener(buttons, this)
    }
}