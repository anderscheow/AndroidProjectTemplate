package com.example.template_v2.main.splash

import android.os.Bundle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.base.activity.LifecycleActivity
import com.example.common.util.ext.navigateTo
import com.example.template_v2.feature_one.api.FeatureOneRouteConstant
import com.example.template_v2.main.R
import com.example.template_v2.main.api.MainRouterConstant
import com.example.template_v2.main.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
@Route(path = MainRouterConstant.Activity.PATH_SPLASH)
class SplashActivity : LifecycleActivity<SplashViewModel>(
    R.layout.activity_splash,
    SplashViewModel::class.java
) {

    private val binding by viewBinding(ActivitySplashBinding::bind)

    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)

        viewModel.start()
    }

    override fun initViews() {
    }

    override fun initListeners() {
    }

    override fun setupViewModelObserver() {
        super.setupViewModelObserver()
        viewModel.state
            .flowWithLifecycle(lifecycle)
            .onEach { state -> handleSplashState(state) }
            .launchIn(lifecycleScope)
    }

    private fun handleSplashState(state: SplashState) {
        when (state) {
            SplashState.Init -> Unit

            SplashState.InitialActionCompleted -> {
                moveToTargetedScreen()
            }
        }
    }

    private fun moveToTargetedScreen() {
        when (applicationInfo.labelRes) {
            R.string.app_name_feature_one -> {
                ARouter.getInstance().navigateTo(FeatureOneRouteConstant.Activity.PATH_MAIN)
            }
        }
        finishAffinity()
    }

    private fun handleAppLinkIntent() {
        intent?.data?.let { data ->
            // Todo: Handle deep link
        }
    }
}