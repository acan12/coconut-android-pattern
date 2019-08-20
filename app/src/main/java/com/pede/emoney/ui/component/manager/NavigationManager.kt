package com.pede.emoney.ui.component.manager

import android.content.Intent
import com.pede.emoney.App
import com.pede.emoney.ui.component.impl.IHomeNavigation
import com.pede.emoney.ui.component.impl.INavigation

class NavigationManager : INavigation {
    override fun homeNavigation(intent: Intent): IHomeNavigation {
        return App.uiComponent?.inject(HomeNavigation())!!
    }
}