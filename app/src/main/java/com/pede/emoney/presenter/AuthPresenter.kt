package com.pede.emoney.presenter

import android.content.Context
import app.beelabs.com.codebase.base.BasePresenter
import app.beelabs.com.codebase.base.IView
import app.beelabs.com.codebase.support.rx.RxObserver
import com.pede.emoney.model.api.request.SignInRequestModel
import com.pede.emoney.model.api.request.SignUpRequesModel
import com.pede.emoney.model.api.response.CheckVersionResponseModel
import com.pede.emoney.model.dao.AuthDao
import com.pede.emoney.ui.IAuthView

class AuthPresenter() : BasePresenter(), AuthDao.IAuthDao {

    lateinit var iAuthView : IAuthView

    constructor(iview : IView) : this() {
        this.iAuthView = iview as IAuthView
    }

    override fun signUp(request: SignUpRequesModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun signIn(request: SignInRequestModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCheckVersion() {
        AuthDao.instance.checkVersion()
            .subscribe(object : RxObserver<CheckVersionResponseModel>(iAuthView, "Check Version...", 10000) {
                override fun onNext(o: Any) {
                    super.onNext(o)
                    iAuthView.handleCheckVersion(o as CheckVersionResponseModel)
                }
            })
//        AuthDao.instance.checkVersion()
//            .subscribe(object -> RxObserver<CheckVersionResponseModel>(iAuthView, "Ambil Data Summary...", 10000) {
//                @Override
//                public void onSubscribe(Disposable d) {
//                    super.onSubscribe(d);
//
//                }
//
//                @Override
//                public void onNext(Object o) {
//                    super.onNext(o);
//                    ifv.handleDataSummary((SummaryResponse) o);
//                }
//            });
    }


    override fun getPresenter(): BasePresenter {
        return this
    }

    override fun getContext(): Context {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}