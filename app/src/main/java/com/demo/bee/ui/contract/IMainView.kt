package com.demo.bee.ui.contract

import app.beelabs.com.codebase.base.contract.IView
import com.demo.bee.model.api.response.SourceResponse

interface IMainView : IView {
    fun handleProcessing()
    fun handleDataSource(model: SourceResponse?)
}