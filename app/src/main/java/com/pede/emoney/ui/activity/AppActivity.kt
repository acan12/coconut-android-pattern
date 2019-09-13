package com.pede.emoney.ui.activity

import android.content.Context
import app.beelabs.com.codebase.base.BaseActivity
import com.pede.emoney.BuildConfig
import com.pede.emoney.R

open class AppActivity : BaseActivity() {

    fun appVersionLabel(context: Context): String {
        var version = context.getString(R.string.version, BuildConfig.VERSION_NAME);
        if (BuildConfig.DEBUG) version = "Dev | $version"
        return version
    }
}