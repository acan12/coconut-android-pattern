package com.pede.emoney.ui.component

import app.beelabs.com.codebase.di.component.AppComponent
import com.pede.emoney.ui.component.impl.IBaseNavigation
import com.pede.emoney.ui.component.impl.IHomeNavigation
import com.pede.emoney.ui.component.impl.INavigation
import com.pede.emoney.ui.component.module.EventModule
import com.pede.emoney.ui.component.module.NavModule
import com.pede.emoney.ui.component.module.LogicUIModule
import com.pede.emoney.ui.component.scope.UIScope
import dagger.Component

@UIScope
@Component(modules = [NavModule::class], dependencies = [AppComponent::class])
interface UIComponent {
    fun inject(iNavigation: INavigation): INavigation
    fun inject(iHomeNavigation: IHomeNavigation): IHomeNavigation

    fun newSupportSubcomponent() : SupportSubComponent
}

