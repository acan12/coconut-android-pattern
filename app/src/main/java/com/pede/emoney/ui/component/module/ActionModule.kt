package com.pede.emoney.ui.component.module

import com.pede.emoney.ui.component.IAction
import com.pede.emoney.ui.component.manager.ActionManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActionModule {

    @Singleton
    @Provides
    fun provideAction(): IAction {
        return ActionManager()
    }


}