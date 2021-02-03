package com.easipos.template.activities.main.mvp

import android.app.Application
import com.easipos.template.api.requests.user.UpdateProfileRequestModel
import com.easipos.template.models.Result
import com.easipos.template.repositories.user.UserRepository
import com.easipos.template.util.ErrorUtil
import io.github.anderscheow.library.mvp.AbstractPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.kodein.di.instance

class MainPresenter(application: Application) : AbstractPresenter<MainView>(application) {

    private val userRepository by instance<UserRepository>()

    fun updateUserInfo(model: UpdateProfileRequestModel) {
        view?.setLoadingIndicator(true)
        launch {
            val result = userRepository.updateUserInfo(model)
            withContext(Dispatchers.Main) {
                view?.setLoadingIndicator(false)

                when (result) {
                    is Result.Success -> {
                        view?.updateUI()
                    }

                    is Result.Error -> {
                        view?.showErrorAlertDialog(ErrorUtil.parseException(result.exception))
                    }

                    else -> {
                    }
                }
            }
        }
    }
}
