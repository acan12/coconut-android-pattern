package com.demo.bee.ui.component.module

import com.demo.bee.ui.component.IEvent
import com.demo.bee.ui.component.manager.EventManager
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