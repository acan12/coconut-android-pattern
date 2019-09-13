package com.pede.emoney.ui.component.module

import com.pede.emoney.ui.component.impl.INavigation
import com.pede.emoney.ui.component.manager.NavigationManager
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