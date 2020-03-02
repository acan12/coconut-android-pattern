package com.demo.bee.ui.component

import com.demo.bee.ui.component.module.ActionModule
import com.demo.bee.ui.component.module.ListenerModule
import com.demo.bee.ui.component.module.LogicUIModule
import com.demo.bee.ui.component.scope.SupportScope
import dagger.Subcomponent

@SupportScope
@Subcomponent(modules = [LogicUIModule::class, ActionModule::class, ListenerModule::class])
interface SupportSubComponent {

    fun inject(logic: ILogic): ILogic
    fun inject(action: IAction): IAction
    fun inject(listener: IListener): IListener
}