package com.pede.emoney.model.dao

import app.beelabs.com.codebase.base.BaseDao
import app.beelabs.com.codebase.base.IDaoPresenter
import app.clappingape.com.elevaniamartpos.model.api.Api
import com.pede.emoney.model.api.request.SignInRequestModel
import com.pede.emoney.model.api.request.SignUpRequesModel
import com.pede.emoney.model.api.response.CheckVersionResponseModel
import com.pede.emoney.model.api.response.SignInResponseModel
import com.pede.emoney.model.api.response.SignUpResponseModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AuthDao : BaseDao() {

    interface IAuthDao : IDaoPresenter {
        fun signUp(request: SignUpRequesModel)
        fun signIn(request: SignInRequestModel)
        fun getCheckVersion()
    }


    companion object {
        val instance: AuthDao by lazy {
            AuthDao()
        }
    }


    fun checkVersion(): Observable<CheckVersionResponseModel> {
        return Api.checkAppVersion().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun signUp(request: SignUpRequesModel): Observable<SignUpResponseModel> {
        return Api.doSignUp(request).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun signIn(request: SignInRequestModel): Observable<SignInResponseModel> {
        return Api.doSignIn(request).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}