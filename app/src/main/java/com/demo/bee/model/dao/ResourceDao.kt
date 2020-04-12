package com.demo.bee.model.dao

import app.beelabs.com.codebase.base.BaseDao
import app.beelabs.com.codebase.base.contract.IDaoPresenter
import com.demo.bee.model.api.Api
import com.demo.bee.model.api.response.SourceResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ResourceDao(var rdao: IResourceDao) : BaseDao() {

    interface IResourceDao : IDaoPresenter {
        fun getSource(messageLoading: String?, dialogType: Int)
    }

    fun getSourceRXDAO(): Observable<SourceResponse?>? {
        return Api.doApiRXSources()!!.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}