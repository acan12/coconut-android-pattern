package com.demo.bee.presenter

import app.beelabs.com.codebase.base.BasePresenter
import app.beelabs.com.codebase.base.contract.IView
import app.beelabs.com.codebase.support.rx.RxObserver
import com.demo.bee.model.api.response.SourceResponse
import com.demo.bee.model.dao.ResourceDao
import com.demo.bee.ui.contract.IMainView

class ResourcePresenter(var iView : IView) : BasePresenter(), ResourceDao.IResourceDao {

    override fun getSource(messageLoading: String?, dialogType: Int) {
        ResourceDao(this).getSourceRXDAO()!!
            .subscribe(object : RxObserver<SourceResponse?>(iView, messageLoading){
                override fun onNext(o: Any) {
                    super.onNext(o)
                    (iView as IMainView).handleDataSource(o as SourceResponse)
                }
            })
    }

//    fun getSourceRX(messageLoading: String?, dialogType: Int) {
//        ResourceDao(this).getSourceRXDAO()
//            .subscribe(object : RxObserver<ProfileResponseModel?>(iView, messageLoading) {
//                override fun onNext(o: Any) {
//                    super.onNext(o)
//                    if (iView is IMainView) (iView as IMainView).handleDataSource(o as SourceResponse) else if (iView is ISecondView) (iView as ISecondView).handleDataSource(
//                        o as SourceResponse
//                    )
//                }
//            }.setDialogType(dialogType))
//    }
}