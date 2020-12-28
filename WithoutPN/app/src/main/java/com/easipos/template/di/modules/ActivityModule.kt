package com.easipos.template.di.modules

import com.easipos.template.activities.main.navigation.MainNavigation
import com.easipos.template.activities.main.navigation.MainNavigationImpl
import com.easipos.template.activities.splash.navigation.SplashNavigation
import com.easipos.template.activities.splash.navigation.SplashNavigationImpl
import io.github.anderscheow.library.di.modules.ActivityBaseModule
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.provider

class ActivityModule : ActivityBaseModule() {
    override fun provideAdditionalModule(builder: DI.Builder) {
        builder.apply {
            bind<SplashNavigation>() with provider { SplashNavigationImpl() }
            bind<MainNavigation>() with provider { MainNavigationImpl() }
        }
    }
}
