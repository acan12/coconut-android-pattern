package com.demo.bee.ui.component.manager

import android.content.Intent
import com.demo.bee.App
import com.demo.bee.ui.component.impl.IHomeNavigation
import com.demo.bee.ui.component.impl.INavigation
import com.demo.bee.ui.component.manager.nav.HomeNavigation

class NavigationManager : INavigation {
    override fun homeNavigation(intent: Intent): IHomeNavigation {
        return App.uiComponent?.inject(HomeNavigation())!!
    }
}