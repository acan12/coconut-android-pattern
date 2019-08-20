package com.pede.emoney.ui.component.module

import com.pede.emoney.ui.component.impl.IAnimationLogic
import com.pede.emoney.ui.component.impl.IPaymentLogic
import com.pede.emoney.ui.component.manager.AnimationLogicManager
import com.pede.emoney.ui.component.manager.PaymentLogicManager
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