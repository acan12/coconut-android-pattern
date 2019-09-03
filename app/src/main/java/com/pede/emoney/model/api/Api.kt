package app.clappingape.com.elevaniamartpos.model.api

import app.beelabs.com.codebase.base.BaseApi
import com.pede.emoney.Pede
import com.pede.emoney.IConfig
import com.pede.emoney.model.api.request.SignInRequestModel
import com.pede.emoney.model.api.request.SignUpRequesModel
import com.pede.emoney.model.api.response.CheckVersionResponseModel
import com.pede.emoney.model.api.response.SignInResponseModel
import com.pede.emoney.model.api.response.SignUpResponseModel
import com.pede.emoney.ui.component.manager.data.SessionManager
import io.reactivex.Observable


class Api : BaseApi() {

    companion object {
        private fun initHeader(): Map<String, String> {
            val map = HashMap<String, String>()
            map["Authorization"] = SessionManager.getCredential(Pede.applicationContext())
            map["Content-Type:"] = "application/json"
            map["partnerCode:"] = "PEDE"
            return map
        }

        @Synchronized
        private fun initApiDomain(): ApiService {
            BaseApi.getInstance().apiDomain = IConfig.API_BASE_URL
            return getInstance().setupApi(
                Pede.getAppComponent(),
                ApiService::class.java,
                true
            ) as ApiService
        }


        /**
         * USERS
         */
        @Synchronized
        fun doSignUp(request: SignUpRequesModel): Observable<SignUpResponseModel> {
            return initApiDomain().signUp(initHeader(), request)
        }

        @Synchronized
        fun doSignIn(request: SignInRequestModel): Observable<SignInResponseModel> {
            return initApiDomain().signIn(initHeader(), request)
        }

        /**
         * CMS
         */

        // CMS Check Pede Version
        @Synchronized
        fun checkAppVersion(): Observable<CheckVersionResponseModel> {
            return initApiDomain().checkAppVersion(initHeader())
        }
    }
}