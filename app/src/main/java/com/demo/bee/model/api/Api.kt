package com.demo.bee.model.api

import app.beelabs.com.codebase.base.BaseApi
import app.beelabs.com.codebase.component.interceptor.RSAInterceptor
import com.demo.bee.App
import com.demo.bee.BuildConfig
import com.demo.bee.IConfig
import com.demo.bee.model.api.response.SourceResponse
import com.demo.bee.model.dao.SessionManager
import io.reactivex.Observable


class Api : BaseApi() {

    companion object {
        private fun initHeader(): Map<String, String> {
            val map = HashMap<String, String>()
            map["Authorization"] = SessionManager.getCredential(App.applicationContext())
//            map["Cache-Control"] = ""
//            map["Content-type"] = ""
            return map
        }

        @Synchronized
        private fun initApiDomain(): ApiService {
            return getInstance().setupApiDomain(
                IConfig.API_BASE_URL,
                App.getAppComponent(),
                ApiService::class.java,
                true,
                60,
                BuildConfig.DEBUG,
                arrayOf( RSAInterceptor() )
            ) as ApiService
        }


        @Synchronized
        fun doApiRXSources(): Observable<SourceResponse?>? {
            return Api.initApiDomain().callApiRXSources("en")
        }

    }
}