package com.easipos.template.activities.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.easipos.template.R
import com.easipos.template.activities.main.mvp.MainPresenter
import com.easipos.template.activities.main.mvp.MainView
import com.easipos.template.activities.main.navigation.MainNavigation
import io.github.anderscheow.library.appCompat.activity.MvpBaseActivity
import org.kodein.di.instance

class MainActivity : MvpBaseActivity<MainView, MainPresenter>() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    //region Variables
    private val navigation by instance<MainNavigation>()
    //endregion

    //region Lifecycle
    //endregion

    //region CustomBaseAppCompatActivity Abstract Methods
    override fun getResLayout(): Int = R.layout.activity_main

    override fun getMvpView(): MainView {
        return object : MainView {
            override fun toastMessage(message: CharSequence) {
            }

            override fun toastMessage(message: Int) {
            }

            override fun setLoadingIndicator(active: Boolean, message: Int) {
                checkLoadingIndicator(active, message)
            }

            override fun showErrorAlertDialog(message: CharSequence, title: CharSequence?, action: () -> Unit) {
            }
        }
    }

    override fun getPresenter(): MainPresenter {
        return MainPresenter(application)
    }

    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
    }
    //endregion

    //region Action Methods
    //endregion
}
