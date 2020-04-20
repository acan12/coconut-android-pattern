package com.demo.bee.ui.component.impl

import android.content.Intent

interface INavigation : IBaseNavigation {
    fun homeNavigation(intent: Intent): IHomeNavigation

}