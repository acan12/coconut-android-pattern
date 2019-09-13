package com.pede.emoney

import android.content.Context
import app.beelabs.com.codebase.base.BaseApp
import app.beelabs.com.codebase.di.component.AppComponent
import app.beelabs.com.codebase.di.component.DaggerAppComponent
import com.google.firebase.FirebaseApp
import com.pede.emoney.ui.component.DaggerUIComponent
import com.pede.emoney.ui.component.IAction
import com.pede.emoney.ui.component.SupportSubComponent
import com.pede.emoney.ui.component.UIComponent
import com.pede.emoney.ui.component.impl.IAnimation
import com.pede.emoney.ui.component.impl.IListener
import com.pede.emoney.ui.component.impl.INavigation
import com.pede.emoney.ui.component.manager.ActionManager
import com.pede.emoney.ui.component.manager.AnimationManager
import com.pede.emoney.ui.component.manager.ListenerManager
import com.pede.emoney.ui.component.manager.NavigationManager
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
        fun getAnimationUI(): IAnimation {
            return supportSubComponent?.inject(AnimationManager())!!
        }


        // Module Event
        fun getAction(): IAction {
            return supportSubComponent?.inject(ActionManager())!!
        }

        // Module Listener
        fun getListener(): IListener {
            return supportSubComponent?.inject(ListenerManager())!!
        }

    }

    @Suppress("DEPRECATION")
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this) //Setup Firebase

        setupBuilder(DaggerAppComponent.builder(), this)

        setupDefaultFont("fonts/Regular.otf")

        uiComponent = DaggerUIComponent.builder().appComponent(getAppComponent())
            .navModule(NavModule()).build()

        supportSubComponent = DaggerUIComponent.builder().appComponent(getAppComponent()).build()
            .newSupportSubcomponent()

    }

}