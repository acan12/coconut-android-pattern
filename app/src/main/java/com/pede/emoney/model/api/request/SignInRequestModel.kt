package com.pede.emoney.model.api.request

open class SignInRequestModel {
    constructor(
        mobilePhoneNumber: String?,
        pin: String?,
        deviceId: String?,
        firebaseToken: String?,
        trans: String?,
        provider: String?,
        latitude: String?,
        longitude: String?
    ) {
        this.mobilePhoneNumber = mobilePhoneNumber
        this.pin = pin
        this.deviceId = deviceId
        this.firebaseToken = firebaseToken
        this.trans = trans
        this.provider = provider
        this.latitude = latitude
        this.longitude = longitude
    }

    var mobilePhoneNumber: String? = null
    var pin: String? = null
    var deviceId: String? = null
    var firebaseToken: String? = null
    var trans: String? = null
    var provider: String? = null
    var latitude: String? = null
    var longitude: String? = null
}