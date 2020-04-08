package com.demo.bee.model.api.response

import app.beelabs.com.codebase.base.response.BaseResponse
import com.demo.bee.model.data.Source

class SourceResponse : BaseResponse() {
    private var sources: List<Source?>? = null

    fun getSources(): List<Source?>? {
        return sources
    }

    fun setSources(sources: List<Source?>?) {
        this.sources = sources
    }
}