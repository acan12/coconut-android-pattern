package com.pede.emoney

import android.content.Context
import app.beelabs.com.codebase.base.BaseApp
import app.beelabs.com.codebase.di.component.AppComponent
import app.beelabs.com.codebase.di.component.DaggerAppComponent
import com.google.firebase.FirebaseApp
import com.pede.emoney.ui.component.*
import com.pede.emoney.ui.component.impl.INavigation
import com.pede.emoney.ui.component.manager.ActionManager
import com.pede.emoney.ui.component.manager.AnimationUIManager
import com.pede.emoney.ui.component.manager.PaymentUIManager
import com.pede.emoney.ui.component.manager.nav.NavigationManager
import com.pede.emoney.ui.component.module.NavModule

class Pede : BaseApp() {

    init {
        instance = this
    }

    companion object {

        var uiComponent: UIComponent? = null
        var supportSubComponent: SupportSubComponent? = null
        private var instance: Pede? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }


        fun getAppComponent(): AppComponent? {
            return getComponent()
        }

        fun getNavigationComponent(): INavigation {
            return uiComponent?.inject(NavigationManager())!!
        }

        // Module UI Preview
        fun getPaymentUI(): IUi {
            return supportSubComponent?.inject(PaymentUIManager())!!
        }

        fun getAnimationUI(): IUi {
            return supportSubComponent?.inject(AnimationUIManager())!!
        }


        // Module Event
        fun getAction(): IAction {
            return supportSubComponent?.inject(ActionManager())!!
        }

    }

    @Suppress("DEPRECATION")
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(SplashActivity@ this) //Setup Firebase

        setupBuilder(DaggerAppComponent.builder(), this)
        setupDefaultFont("font/Avenir-Medium.ttf")

        uiComponent = DaggerUIComponent.builder().appComponent(getAppComponent())
            .navModule(NavModule()).build()

        supportSubComponent = DaggerUIComponent.builder().appComponent(getAppComponent()).build()
            .newSupportSubcomponent()

    }

}