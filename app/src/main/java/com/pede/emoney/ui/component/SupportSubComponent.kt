package com.pede.emoney.ui.component

import com.pede.emoney.ui.component.module.EventModule
import com.pede.emoney.ui.component.module.LogicUIModule
import com.pede.emoney.ui.component.scope.SupportScope
import dagger.Subcomponent

@SupportScope
@Subcomponent(modules = [LogicUIModule::class, EventModule::class])
interface SupportSubComponent {

    fun inject(logic: ILogic): ILogic
    fun inject(event: IEvent): IEvent
}