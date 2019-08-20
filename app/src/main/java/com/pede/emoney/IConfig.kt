package com.pede.emoney

interface IConfig {
    companion object {

        val KEY_DATA_SECOND_ACTIVITY = "KEY_SECOND"
        val API_BASE_URL = "http://"
        val SESSION_TOKEN_CREDENTIAL = ""
        val SESSION_LOGIN_KEY = "session_login"

        private const val PACKAGE_NAME_INSURANCE_FEATURE = "com.pede.insurance_feature.ui.activity"

        const val MODULE_INSURANCE_CLASSNAME = "$PACKAGE_NAME_INSURANCE_FEATURE.InsuranceHomeActivity"
    }
}
