package com.pede.emoney.model.api.response

import app.beelabs.com.codebase.base.response.BaseResponse
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class CheckVersionResponseModel : BaseResponse() {

    var data: DataResponse? = null
    var code: Int = 0
    var message: String? = null

    @JsonIgnoreProperties(ignoreUnknown = true)
    class DataResponse {
        @JsonProperty("android_app_url")
        var androidAppUrl: String? = null
        @JsonProperty("android_min_version")
        var androidMinVersion: String? = null
        @JsonProperty("ios_app_url")
        var iosAppUrl: String? = null
        @JsonProperty("ios_min_version")
        var iosMinVersion: String? = null
        @JsonProperty("version")
        var version: String? = null
        @JsonProperty("versionCms")
        var versionCms: String? = null
    }
}