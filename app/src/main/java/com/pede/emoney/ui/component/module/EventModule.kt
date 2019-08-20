package com.pede.emoney.ui.component.module

import com.pede.emoney.ui.component.IEvent
import com.pede.emoney.ui.component.manager.EventManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class EventModule {

    @Singleton
    @Provides
    fun provideEvent(): IEvent {
        return EventManager()
    }


}