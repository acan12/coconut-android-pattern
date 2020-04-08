package com.demo.bee.presenter

import app.beelabs.com.codebase.base.BasePresenter
import com.demo.bee.model.dao.ResourceDao

class ResourcePresenter : BasePresenter(), ResourceDao.IResourceDao {

    override fun getSource(messageLoading: String?, dialogType: Int) {

    }
}