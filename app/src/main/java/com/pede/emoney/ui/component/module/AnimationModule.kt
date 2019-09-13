package com.pede.emoney.ui.component.module

import com.pede.emoney.ui.component.impl.IAnimation
import com.pede.emoney.ui.component.manager.AnimationManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AnimationModule {

    @Singleton
    @Provides
    fun provideAnimationView(): IAnimation {
        return AnimationManager()
    }
}