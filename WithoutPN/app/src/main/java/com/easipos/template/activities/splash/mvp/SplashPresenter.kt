package com.easipos.template.activities.splash.mvp

import android.app.Application
import com.easipos.template.api.requests.precheck.CheckVersionRequestModel
import com.easipos.template.managers.UserManager
import com.easipos.template.models.Result
import com.easipos.template.repositories.precheck.PrecheckRepository
import com.easipos.template.room.RoomService
import com.easipos.template.tools.Preference
import io.github.anderscheow.library.mvp.AbstractPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.kodein.di.instance

class SplashPresenter(application: Application)
    : AbstractPresenter<SplashView>(application) {

    private val roomService by instance<RoomService>()
    private val precheckRepository by instance<PrecheckRepository>()

    fun clearDb() {
        launch {
            roomService.runInTransaction {
                roomService.clearAllTables()
            }
        }
    }

    fun checkVersion() {
        launch {
            val result = precheckRepository.checkVersion(CheckVersionRequestModel())
            withContext(Dispatchers.Main) {
                when (result) {
                    is Result.Success<Boolean> -> {
                        if (result.data) {
                            view?.showUpdateAppDialog()
                        } else {
                            checkIsAuthenticated()
                        }
                    }

                    is Result.Error -> {
                        checkIsAuthenticated()
                    }

                    else -> {
                    }
                }
            }
        }
    }

    fun checkIsAuthenticated() {
        if (Preference.prefIsLoggedIn && UserManager.token != null) {
            view?.navigateToMain()
        } else {
            view?.navigateToLogin()
        }
    }
}

