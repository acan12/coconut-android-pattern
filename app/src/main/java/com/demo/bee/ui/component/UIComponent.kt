package com.demo.bee.ui.component

import app.beelabs.com.codebase.di.component.AppComponent
import com.demo.bee.ui.component.impl.IHomeNavigation
import com.demo.bee.ui.component.impl.INavigation
import com.demo.bee.ui.component.module.NavModule
import com.demo.bee.ui.component.scope.UIScope
import dagger.Component

@UIScope
@Component(modules = [NavModule::class], dependencies = [AppComponent::class])
interface UIComponent {
    fun inject(iNavigation: INavigation): INavigation
    fun inject(iHomeNavigation: IHomeNavigation): IHomeNavigation

    fun newSupportSubcomponent() : SupportSubComponent
}

