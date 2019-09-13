package com.pede.emoney.ui.component

import com.pede.emoney.ui.component.impl.IAnimation
import com.pede.emoney.ui.component.impl.IListener
import com.pede.emoney.ui.component.module.ActionModule
import com.pede.emoney.ui.component.module.ListenerModule
import com.pede.emoney.ui.component.module.AnimationModule
import com.pede.emoney.ui.component.scope.SupportScope
import dagger.Subcomponent

@SupportScope
@Subcomponent(modules = [AnimationModule::class, ActionModule::class, ListenerModule::class])
interface SupportSubComponent {

    fun inject(animation: IAnimation): IAnimation
    fun inject(action: IAction): IAction
    fun inject(listener: IListener): IListener
}