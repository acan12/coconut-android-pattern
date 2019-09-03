package com.pede.emoney.ui.component.manager.nav

import android.content.Intent
import com.pede.emoney.Pede
import com.pede.emoney.ui.component.impl.IHomeNavigation
import com.pede.emoney.ui.component.impl.INavigation

class NavigationManager : INavigation {
    override fun homeNavigation(intent: Intent): IHomeNavigation {
        return Pede.uiComponent?.inject(HomeNavigation())!!
    }
}