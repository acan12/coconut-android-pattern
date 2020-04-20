package com.demo.bee

import android.content.Context
import android.util.Log
import app.beelabs.com.codebase.base.BaseApp
import app.beelabs.com.codebase.di.component.AppComponent
import app.beelabs.com.codebase.di.component.DaggerAppComponent
import com.demo.bee.ui.component.*
import com.demo.bee.ui.component.impl.INavigation
import com.demo.bee.ui.component.manager.*
import com.demo.bee.ui.component.module.NavModule

class App : BaseApp() {


    companion object {

        var uiComponent: UIComponent? = null
        var supportSubComponent: SupportSubComponent? = null
        private var instance: App? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }


        fun getAppComponent(): AppComponent? {
            return getComponent()
        }

        fun getNavigationComponent(): INavigation {
            return uiComponent?.inject(NavigationManager())!!
        }

        fun getListener(): IListener? {
            return supportSubComponent?.inject(ListenerManager())
        }

//        fun getHomeNavigationComponent(): IHomeNavigation {
//            return uiComponent?.inject(HomeNavigation())!!
//        }


        // Module LogicUI
        fun getPaymentLogic(): ILogic {
            return supportSubComponent?.inject(PaymentLogicManager())!!
        }

        fun getAnimationLogic(): ILogic {
            return supportSubComponent?.inject(AnimationLogicManager())!!
        }


        // Module Event
        fun getAction(): IAction {
            return supportSubComponent?.inject(ActionManager())!!
        }

    }

    @Suppress("DEPRECATION")
    override fun onCreate() {
        super.onCreate()

        setupBuilder(DaggerAppComponent.builder(), this)
        setupDefaultFont("fonts/Medium.otf")

        uiComponent = DaggerUIComponent.builder().appComponent(getAppComponent())
            .navModule(NavModule()).build()

        supportSubComponent = DaggerUIComponent.builder().appComponent(getAppComponent()).build()
            .newSupportSubcomponent()


        Log.d("", "")

    }

}