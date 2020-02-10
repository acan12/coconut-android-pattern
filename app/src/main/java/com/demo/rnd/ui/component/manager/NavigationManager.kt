package com.demo.rnd.ui.component.manager

import android.content.Intent
import com.demo.rnd.App
import com.demo.rnd.ui.component.impl.IHomeNavigation
import com.demo.rnd.ui.component.impl.INavigation

class NavigationManager : INavigation {
    override fun homeNavigation(intent: Intent): IHomeNavigation {
        return App.uiComponent?.inject(HomeNavigation())!!
    }
}