package com.demo.bee.ui.component

import com.demo.bee.ui.component.module.EventModule
import com.demo.bee.ui.component.module.LogicUIModule
import com.demo.bee.ui.component.scope.SupportScope
import dagger.Subcomponent

@SupportScope
@Subcomponent(modules = [LogicUIModule::class, EventModule::class])
interface SupportSubComponent {

    fun inject(logic: ILogic): ILogic
    fun inject(event: IEvent): IEvent
}