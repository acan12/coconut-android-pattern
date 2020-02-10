package com.demo.rnd.ui.component.module

import com.demo.rnd.ui.component.IEvent
import com.demo.rnd.ui.component.manager.EventManager
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