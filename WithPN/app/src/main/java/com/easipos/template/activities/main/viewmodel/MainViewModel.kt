package com.easipos.template.activities.main.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.easipos.template.api.requests.BasicRequestModel
import com.easipos.template.models.Result
import com.easipos.template.models.UserInfo
import com.easipos.template.repositories.user.UserRepository
import com.easipos.template.util.ErrorUtil
import io.github.anderscheow.library.viewModel.BaseAndroidViewModel
import io.github.anderscheow.library.viewModel.util.AlertDialogData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.kodein.di.instance

class MainViewModel(application: Application) : BaseAndroidViewModel<Void>(application) {

    //region Observable Field
    val userInfo = ObservableField<UserInfo>()
    //endregion

    private val userRepository by instance<UserRepository>()

    override fun start(args: Void?) {
        getUserInfo()
    }

    private fun getUserInfo() {
        setIsLoading(true)
        viewModelScope.launch {
            val result = userRepository.getUserInfo(BasicRequestModel())
            withContext(Dispatchers.Main) {
                setIsLoading(false)

                when (result) {
                    is Result.Success<UserInfo?> -> {
                        setUserInfo(result.data)
                    }

                    is Result.Error -> {
                        showAlertDialog(AlertDialogData(ErrorUtil.parseException(result.exception)))
                    }

                    else -> {
                    }
                }
            }
        }
    }

    private fun setUserInfo(userInfo: UserInfo?) {
        this.userInfo.set(userInfo)
        this.userInfo.notifyChange()
    }
}