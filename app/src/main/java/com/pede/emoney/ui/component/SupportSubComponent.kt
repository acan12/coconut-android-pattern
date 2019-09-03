package com.pede.emoney.ui.component

import com.pede.emoney.ui.component.module.ActionModule
import com.pede.emoney.ui.component.module.UIModule
import com.pede.emoney.ui.component.scope.SupportScope
import dagger.Subcomponent

@SupportScope
@Subcomponent(modules = [UIModule::class, ActionModule::class])
interface SupportSubComponent {

    fun inject(ui: IUi): IUi
    fun inject(action: IAction): IAction
}