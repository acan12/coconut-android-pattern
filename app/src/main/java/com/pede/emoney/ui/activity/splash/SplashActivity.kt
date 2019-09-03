package com.pede.emoney.ui.activity.splash

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import app.beelabs.com.codebase.base.BaseActivity
import app.beelabs.com.codebase.base.BasePresenter
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.pede.emoney.Pede
import com.pede.emoney.R
import com.pede.emoney.model.api.response.CheckVersionResponseModel
import com.pede.emoney.presenter.AuthPresenter
import com.pede.emoney.ui.impl.ISplashView

class SplashActivity : BaseActivity(), ISplashView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        (BasePresenter.getInstance(this, AuthPresenter::class.java) as AuthPresenter).getCheckVersion()

        Pede.getAction().getFirebaseToken(this)
    }

    override fun handleCheckVersion(model: CheckVersionResponseModel) {
        Toast.makeText(this, "version: " + model.data!!.androidMinVersion, Toast.LENGTH_SHORT)
            .show()
    }
}