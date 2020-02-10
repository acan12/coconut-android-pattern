package com.demo.rnd.ui.component.module

import com.demo.rnd.ui.component.impl.INavigation
import com.demo.rnd.ui.component.manager.NavigationManager
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