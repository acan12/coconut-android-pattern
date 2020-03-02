package com.demo.bee.ui.component.module

import com.demo.bee.ui.component.IAction
import com.demo.bee.ui.component.manager.ActionManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActionModule {

    @Singleton
    @Provides
    fun provideEvent(): IAction {
        return ActionManager()
    }


}