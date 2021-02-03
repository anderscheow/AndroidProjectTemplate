package com.easipos.template.activities.splash.mvp

import io.github.anderscheow.library.mvp.BaseView

interface SplashView : BaseView {

    fun showUpdateAppDialog()

    fun navigateToLogin()

    fun navigateToMain()
}
