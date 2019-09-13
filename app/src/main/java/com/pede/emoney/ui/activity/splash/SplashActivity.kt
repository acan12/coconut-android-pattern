package com.pede.emoney.ui.activity.splash

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import app.beelabs.com.codebase.base.BaseActivity
import app.beelabs.com.codebase.base.BasePresenter
import app.beelabs.com.codebase.support.util.CacheUtil
import com.pede.emoney.BuildConfig
import com.pede.emoney.IConfig
import com.pede.emoney.Pede
import com.pede.emoney.R
import com.pede.emoney.model.api.response.CheckVersionResponseModel
import com.pede.emoney.presenter.AuthPresenter
import com.pede.emoney.ui.dialog.UpdateConfirmVersionDialog
import com.pede.emoney.ui.impl.ISplashView

class SplashActivity : BaseActivity(), ISplashView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        (BasePresenter.getInstance(
            this,
            AuthPresenter::class.java
        ) as AuthPresenter).getCheckVersion()
        Pede.getAction().putFirebaseTokenToSession(this)
    }

    override fun handleCheckVersion(model: CheckVersionResponseModel) {
        val currentVersion = BuildConfig.VERSION_NAME
        val latestVersion = model.data!!.androidMinVersion
        val hasLatestVersion = Pede.getAction().isLatestVersion(currentVersion, latestVersion!!)

        if (hasLatestVersion) {
            val token = CacheUtil.getPreferenceString(IConfig.SESSION_TOKEN_CREDENTIAL, this)
            val phoneNumber = CacheUtil.getPreferenceString(IConfig.MOBILE_PHONE_NUMBER, this)

            if (TextUtils.isEmpty(token)) {
                if (phoneNumber == "")
                    Pede.getNavigationComponent()
                        .homeNavigation(Intent())
                        .goFirstTimeInstallPage(this)
                else
                    Pede.getNavigationComponent()
                        .homeNavigation(Intent())
                        .goSignIn(this)

            } else Pede.getNavigationComponent().homeNavigation(Intent()).goHomePage(this)

        } else showUpdateDialog()

    }

    private fun showUpdateDialog() {
        UpdateConfirmVersionDialog(this, R.style.CoconutDialogFullScreen).show()
    }
}