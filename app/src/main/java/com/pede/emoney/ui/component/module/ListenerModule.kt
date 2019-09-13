package com.pede.emoney.ui.component.module

import com.pede.emoney.ui.component.impl.IListener
import com.pede.emoney.ui.component.manager.ListenerManager
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