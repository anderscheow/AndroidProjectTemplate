package com.easipos.template.activities.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.easipos.template.R
import com.easipos.template.activities.main.mvp.MainPresenter
import com.easipos.template.activities.main.mvp.MainView
import com.easipos.template.activities.main.navigation.MainNavigation
import com.easipos.template.activities.main.viewmodel.MainViewModel
import com.easipos.template.activities.main.viewmodel.MainViewModelFactory
import com.easipos.template.api.requests.user.UpdateProfileRequestModel
import com.easipos.template.managers.FcmManager
import com.easipos.template.managers.PushNotificationManager
import com.onesignal.OneSignal
import com.orhanobut.logger.Logger
import io.github.anderscheow.library.appCompat.activity.MvpLifecycleActivity
import io.github.anderscheow.library.kotlinExt.click
import io.github.anderscheow.validator.Validator
import io.github.anderscheow.validator.extensions.validate
import io.github.anderscheow.validator.rules.common.notBlank
import io.github.anderscheow.validator.rules.regex.email
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert_dialog_common.*
import org.jetbrains.anko.longToast
import org.kodein.di.instance

class MainActivity : MvpLifecycleActivity<MainViewModel, MainView, MainPresenter>() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    //region Variables
    private val navigation by instance<MainNavigation>()
    private val fcmManager by instance<FcmManager>()
    private val pushNotificationManager by instance<PushNotificationManager>()
    private val validator by instance<Validator>()

    private val factory by lazy { MainViewModelFactory(application) }
    private val mainPresenter by lazy { MainPresenter(application) }
    //endregion

    //region Lifecycle
    //endregion

    //region CustomBaseAppCompatActivity Abstract Methods
    override fun getResLayout(): Int = R.layout.activity_main

    override fun setupViewModel(): MainViewModel {
        return ViewModelProvider(this, factory).get(MainViewModel::class.java)
    }

    override fun setupViewModelObserver() {
    }

    override fun getMvpView(): MainView {
        return object : MainView {
            override fun toastMessage(message: CharSequence) {
                longToast(message)
            }

            override fun toastMessage(message: Int) {
                longToast(message)
            }

            override fun setLoadingIndicator(active: Boolean, message: Int) {
                checkLoadingIndicator(active, message)
            }

            override fun showErrorAlertDialog(
                message: CharSequence,
                title: CharSequence?,
                action: () -> Unit
            ) {
                showYesAlertDialog(message, buttonText = R.string.action_ok, action = action)
            }

            override fun updateUI() {
                viewModel.onRefresh()
            }
        }
    }

    override fun getPresenter(): MainPresenter {
        return mainPresenter
    }

    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)

        observeOneSignalSubscription()
        registerPushTokenIfPossible()
        processPayload()

        setupViews()
        setupListeners()

        viewModel.start()
    }
    //endregion

    //region Action Methods
    fun processPayload() {
        Logger.d(pushNotificationManager.payload)
        pushNotificationManager.payload?.let { _ ->
//            navigateToNotification()
            pushNotificationManager.removePayload()
        }
    }

    private fun observeOneSignalSubscription() {
        OneSignal.addSubscriptionObserver { state ->
            Logger.d(state.toString())
            fcmManager.service.saveFcmToken(state.to.userId)
        }
    }

    private fun registerPushTokenIfPossible() {
        fcmManager.service.registerFcmToken()
    }

    private fun setupViews() {
    }

    private fun setupListeners() {
        button_ok.click {
            attemptUpdate()
        }
    }

    private fun attemptUpdate() {
        val nameValidation = text_input_layout_name.validate()
            .notBlank(R.string.error_field_required)

        val phoneNumberValidation = text_input_layout_phone_number.validate()
            .notBlank(R.string.error_field_required)

        val emailValidation = text_input_layout_email.validate()
            .notBlank(R.string.error_field_required)
            .email("Invalid email")

        validator.setListener(object : Validator.OnValidateListener {
            override fun onValidateFailed(errors: List<String>) {
            }

            override fun onValidateSuccess(values: List<String>) {
                val name = values[0].trim()
                val phoneNumber = values[1].trim()
                val email = values[3].trim()

                val model = UpdateProfileRequestModel(
                    name = name,
                    phoneNumber = phoneNumber,
                    email = email
                )

                getPresenter().updateUserInfo(model)
            }
        }).validate(nameValidation, phoneNumberValidation, emailValidation)
    }
    //endregion
}
