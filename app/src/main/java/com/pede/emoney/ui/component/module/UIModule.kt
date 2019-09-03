package com.pede.emoney.ui.component.module

import com.pede.emoney.ui.component.impl.IAnimationUI
import com.pede.emoney.ui.component.impl.IPaymentUI
import com.pede.emoney.ui.component.manager.AnimationUIManager
import com.pede.emoney.ui.component.manager.PaymentUIManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UIModule {

    @Singleton
    @Provides
    fun providePaymentView(): IPaymentUI {
        return PaymentUIManager()
    }

    @Singleton
    @Provides
    fun provideAnimationView(): IAnimationUI {
        return AnimationUIManager()
    }
}