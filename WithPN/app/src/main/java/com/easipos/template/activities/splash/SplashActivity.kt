package com.easipos.template.activities.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.easipos.template.R
import com.easipos.template.activities.splash.mvp.SplashPresenter
import com.easipos.template.activities.splash.mvp.SplashView
import com.easipos.template.activities.splash.navigation.SplashNavigation
import com.easipos.template.bundle.ParcelData
import io.github.anderscheow.library.appCompat.activity.MvpBaseActivity
import io.github.anderscheow.library.kotlinExt.argument
import io.github.anderscheow.library.kotlinExt.rate
import org.kodein.di.instance

class SplashActivity : MvpBaseActivity<SplashView, SplashPresenter>() {

    companion object {
        fun newIntent(context: Context, clearDb: Boolean = false): Intent {
            return Intent(context, SplashActivity::class.java).apply {
                this.putExtra(ParcelData.CLEAR_DB, clearDb)
            }
        }
    }

    //region Variables
    private val navigation by instance<SplashNavigation>()

    private val splashPresenter by lazy { SplashPresenter(application) }

    private val clearDb by argument(ParcelData.CLEAR_DB, false)
    //endregion

    //region Lifecycle
    //endregion

    //region CustomBaseAppCompatActivity Abstract Methods
    override fun getResLayout(): Int = R.layout.activity_splash

    override fun getMvpView(): SplashView {
        return object : SplashView {
            override fun toastMessage(message: CharSequence) {
            }

            override fun toastMessage(message: Int) {
            }

            override fun setLoadingIndicator(active: Boolean, message: Int) {
                checkLoadingIndicator(active, message)
            }

            override fun showErrorAlertDialog(message: CharSequence, title: CharSequence?, action: () -> Unit) {
            }

            override fun showUpdateAppDialog() {
                showYesAlertDialog(getString(R.string.prompt_update_app), buttonText = R.string.action_upgrade_now) {
                    this@SplashActivity.rate()
                    finishAffinity()
                }
            }

            override fun navigateToLogin() {
            }

            override fun navigateToMain() {
            }
        }
    }

    override fun getPresenter(): SplashPresenter {
        return splashPresenter
    }

    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)

        if (clearDb) {
            getPresenter().clearDb()
        }

        checkVersion()
    }
    //endregion

    //region Action Methods
    private fun checkVersion() {
        getPresenter().checkVersion()
    }
    //endregion
}
