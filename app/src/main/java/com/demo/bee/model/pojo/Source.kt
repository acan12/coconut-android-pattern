package com.demo.bee.model.pojo

import java.io.Serializable

/**
 * Created by arysuryawan on 8/18/17.
 */
class Source : Serializable {
    var id: String? = null
    var name: String? = null
    var description: String? = null
    var url: String? = null
    var category: String? = null
    var language: String? = null
    var country: String? = null
    var urlsToLogos: UrlLogos? = null
    lateinit var sortBysAvailable: Array<String>

    inner class UrlLogos {
        var small: String? = null
        var medium: String? = null
        var large: String? = null

    }
}