package com.pede.emoney.presenter

import android.content.Context
import app.beelabs.com.codebase.base.BasePresenter
import app.beelabs.com.codebase.base.IView
import app.beelabs.com.codebase.support.rx.RxObserver
import com.pede.emoney.model.api.request.SignInRequestModel
import com.pede.emoney.model.api.request.SignUpRequesModel
import com.pede.emoney.model.api.response.CheckVersionResponseModel
import com.pede.emoney.model.api.response.SignInResponseModel
import com.pede.emoney.model.dao.AuthDao
import com.pede.emoney.ui.impl.ISigninView
import com.pede.emoney.ui.impl.ISplashView

class AuthPresenter() : BasePresenter(), AuthDao.IAuthDao {

    lateinit var iSplashView: ISplashView
    lateinit var iSigninView: ISigninView

    constructor(iview: IView) : this() {
        this.iSplashView = iview as ISplashView
        this.iSigninView = iview as ISigninView
    }

    override fun signUp(request: SignUpRequesModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun signIn(request: SignInRequestModel) {
        AuthDao.instance.signIn(request)
            .subscribe(object :
                RxObserver<SignInResponseModel>(iSigninView, null, 10000){
                override fun onNext(o: Any) {
                    super.onNext(o)
                    iSigninView.handleApiSignin(o as SignInResponseModel)
                }
            })
    }

    override fun getCheckVersion() {
        AuthDao.instance.checkVersion()
            .subscribe(object :
                RxObserver<CheckVersionResponseModel>(iSplashView, null, 10000) {
                override fun onNext(o: Any) {
                    super.onNext(o)
                    iSplashView.handleCheckVersion(o as CheckVersionResponseModel)
                }
            })
    }


    override fun getPresenter(): BasePresenter {
        return this
    }

    override fun getContext(): Context {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}