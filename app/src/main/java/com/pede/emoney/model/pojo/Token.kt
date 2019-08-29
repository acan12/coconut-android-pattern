package com.pede.emoney.model.pojo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Token {

    private var access_token: String? = null
    private var token_type: String? = null
    private var expires_in: String? = null
    private var refresh_token: String? = null
    private var scope: String? = null
}