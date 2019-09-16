package com.pede.emoney.ui.activity

import android.os.Bundle
import android.text.Html.fromHtml
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.Toast
import app.beelabs.com.codebase.support.util.CacheUtil
import app.beelabs.com.codebase.support.util.DeviceUtil
import com.pede.emoney.IConfig
import com.pede.emoney.Pede
import com.pede.emoney.R
import com.pede.emoney.model.api.request.SignInRequestModel
import com.pede.emoney.model.api.response.SignInResponseModel
import com.pede.emoney.ui.component.IAction
import com.pede.emoney.ui.component.manager.ListenerManager
import com.pede.emoney.ui.impl.ISigninView
import kotlinx.android.synthetic.main.content_sign_in.*
import support.PhoneUtil

class SigninActivity : AppActivity(), ISigninView, IAction.IGeoLocation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        initView()
    }

    private fun initView() {
        tvVersion.setText(appVersionLabel(this))
        tvSignup.text = fromHtml((getString(R.string.title_activity_no_account)))

        //Add Underline to forogot pin Button
        val forgotLabel = getString(R.string.sign_up_btn_forgot_pin)
        val content = SpannableString(forgotLabel)
        content.setSpan(UnderlineSpan(), 0, forgotLabel.length, 0)
        btnForgotPin.text = content

        Pede.getAction().setupGeoLocation(this)
        Pede.getListener()
            .onSigninWatcherListener(arrayOf(etNoHandphone, etPin), this)

    }

    override fun handlePhoneWatcher() {
        Pede.getAction().validateSignInForm(
            etNoHandphone.text.toString(),
            etPin.text.toString(),
            btnSigninAction,
            this
        )
    }

    override fun handlePinWatcher() {
        Pede.getAction().validateSignInForm(
            etNoHandphone.text.toString(),
            etPin.text.toString(),
            btnSigninAction,
            this
        )
    }

    override fun handleLocationManager(lat: Double, lng: Double) {


        Pede.getListener()
            .onSigninActionListener(btnSigninAction, object: ListenerManager.Helper() {
                override fun callback(): Object? {
                    var request = buildSigninRequest(
                        etNoHandphone.getText().toString(),
                        etPin.getText().toString(),
                        CacheUtil.getPreferenceString(IConfig.SESSION_FIREBASE_TOKEN, this@SigninActivity),
                        lat, lng
                    )

                    return request as Object
                }
            }, this)
    }

    override fun handleApiSignin(response: SignInResponseModel) {
        Toast.makeText(this, "ApiSignin", Toast.LENGTH_SHORT).show()
    }


    private fun buildSigninRequest(
        phone: String,
        pin: String,
        token: String, lat: Double, lng: Double
    ): SignInRequestModel {
        val validPhone = PhoneUtil.countryCodeReplaceWithZero(phone)
        val deviceID = DeviceUtil.getUUID()
        val firebaseToken = token
        return SignInRequestModel(
            validPhone,
            pin,
            deviceID,
            firebaseToken,
            null,
            null,
            lat.toString(),
            lng.toString()
        )
    }
}