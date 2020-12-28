package com.easipos.template.activities.splash.mvp

import io.github.anderscheow.library.mvp.MvpView

interface SplashView : MvpView {

    fun showUpdateAppDialog()

    fun navigateToLogin()

    fun navigateToMain()
}
