package app.clappingape.com.elevaniamartpos.model.api

import com.demo.rnd.App
import com.demo.rnd.IConfig
import com.demo.rnd.ui.component.manager.SessionManager
import app.beelabs.com.codebase.base.BaseApi
import com.demo.rnd.model.api.ApiService


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
            BaseApi.getInstance().apiDomain = IConfig.API_BASE_URL
            return BaseApi.getInstance().setupApi(App.getAppComponent(), ApiService::class.java, true) as ApiService
        }

    }
}