package com.demo.bee.ui.component.module

import com.demo.bee.ui.component.IAction
import com.demo.bee.ui.component.IListener
import com.demo.bee.ui.component.manager.ActionManager
import com.demo.bee.ui.component.manager.ListenerManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ListenerModule {

    @Singleton
    @Provides
    fun provideListener(): IListener {
        return ListenerManager()
    }


}