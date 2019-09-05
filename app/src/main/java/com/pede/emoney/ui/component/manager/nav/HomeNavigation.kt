package com.pede.emoney.ui.component.manager.nav

import android.content.Context
import android.content.Intent
import com.pede.emoney.IConfig
import com.pede.emoney.ui.activity.MainActivity
import com.pede.emoney.ui.activity.SecondActivity
import com.pede.emoney.ui.activity.SigninActivity
import com.pede.emoney.ui.activity.splash.FirstTimeInstallActivity
import com.pede.emoney.ui.component.impl.IHomeNavigation

class HomeNavigation : IHomeNavigation {
    override fun goFirstTimeInstallPage(context: Context) {
        val intent = Intent(context, FirstTimeInstallActivity::class.java)
        context.startActivity(intent)
    }

    override fun goSignIn(context: Context) {
        val intent = Intent(context, SigninActivity::class.java)
        context.startActivity(intent)
    }

    override fun goHomePage(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }

    override fun goSecondPage(txt: String, context: Context) {
        val intent = Intent(context, SecondActivity::class.java)
        intent.putExtra(IConfig.KEY_DATA_SECOND_ACTIVITY, txt)
        context.startActivity(intent)
    }

}