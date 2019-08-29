package com.pede.emoney.model.api.response

import app.beelabs.com.codebase.base.response.BaseResponse
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.pede.emoney.model.pojo.UserData

@JsonIgnoreProperties(ignoreUnknown = true)
class SignUpResponseModel : BaseResponse() {

    private var code: Int = 0
    private var message: String? = null
    private var data: UserData? = null
}