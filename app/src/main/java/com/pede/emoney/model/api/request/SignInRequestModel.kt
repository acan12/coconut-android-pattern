package com.pede.emoney.model.api.request

class SignInRequestModel {
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

    private var mobilePhoneNumber: String? = null
    private var pin: String? = null
    private var deviceId: String? = null
    private var firebaseToken: String? = null
    private var trans: String? = null
    private var provider: String? = null
    private var latitude: String? = null
    private var longitude: String? = null
}