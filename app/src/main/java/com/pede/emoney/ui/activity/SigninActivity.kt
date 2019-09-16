package com.pede.emoney.ui.activity

import android.os.Bundle
import android.text.Html.fromHtml
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.Toast
import com.pede.emoney.Pede
import com.pede.emoney.R
import com.pede.emoney.model.api.response.SignInResponseModel
import com.pede.emoney.ui.impl.ISigninView
import kotlinx.android.synthetic.main.content_sign_in.*

@Suppress("DEPRECATION")
class SigninActivity : AppActivity(), ISigninView {

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

        Pede.getListener()
            .onSigninWatcherListener(arrayOf(etNoHandphone, etPin), this)
            .onSigninActionListener(btnSigninAction, null, this)
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

    override fun handleApiSignin(response: SignInResponseModel) {
        Toast.makeText(this, "ApiSignin", Toast.LENGTH_SHORT).show()
    }

    //    private fun buildSigninRequest() : SignInRequestModel {
//        val phone = PhoneUtil.countryCodeReplaceWithZero(etNoHandphone.getText().toString())
//        val pin = etPin.getText().toString()
//        val deviceID = DeviceUtil.getUUID()
//        val firebaseToken = CacheUtil.getPreferenceString(IConfig.SESSION_FIREBASE_TOKEN, this)
//        return SignInRequestModel(
//            phone,
//            pin,
//            deviceID,
//            firebaseToken,
//            null,
//            null,
//            null,
//            null
//        )
//
////        if (hasMyLocation() != null) {
////            signInRequest.setLatitude(String.valueOf(getMyLastLocation().getLatitude()))
////            signInRequest.setLongitude(String.valueOf(getMyLastLocation().getLongitude()))
////        }
//    }
}