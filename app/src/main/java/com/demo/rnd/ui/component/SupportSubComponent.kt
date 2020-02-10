package com.demo.rnd.ui.component

import com.demo.rnd.ui.component.module.EventModule
import com.demo.rnd.ui.component.module.LogicUIModule
import com.demo.rnd.ui.component.scope.SupportScope
import dagger.Subcomponent

@SupportScope
@Subcomponent(modules = [LogicUIModule::class, EventModule::class])
interface SupportSubComponent {

    fun inject(logic: ILogic): ILogic
    fun inject(event: IEvent): IEvent
}