package com.pede.emoney.model.pojo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class UserData {

    private var email: String? = null
    private var mobilePhoneNumber: String? = null
    private var fullName: String? = null
    private var deviceId: String? = null
    private var id: Int = 0
    private var otpType: Int = 0

}