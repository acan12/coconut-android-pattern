package com.demo.rnd.ui.component.module

import com.demo.rnd.ui.component.impl.IAnimationLogic
import com.demo.rnd.ui.component.impl.IPaymentLogic
import com.demo.rnd.ui.component.manager.AnimationLogicManager
import com.demo.rnd.ui.component.manager.PaymentLogicManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LogicUIModule {

    @Singleton
    @Provides
    fun providePaymentLogic(): IPaymentLogic {
        return PaymentLogicManager()
    }

    @Singleton
    @Provides
    fun provideAnimationLogic(): IAnimationLogic {
        return AnimationLogicManager()
    }
}