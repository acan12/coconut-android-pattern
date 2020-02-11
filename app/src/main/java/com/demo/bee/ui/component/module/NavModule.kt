package com.demo.bee.ui.component.module

import com.demo.bee.ui.component.impl.INavigation
import com.demo.bee.ui.component.manager.NavigationManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavModule {

    @Singleton
    @Provides
    fun provideNavigation(): INavigation {
        return NavigationManager()
    }


}