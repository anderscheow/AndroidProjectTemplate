package com.example.template_v2.main.login

import android.util.Log
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.base.activity.LifecycleActivity
import com.example.common.util.ext.click
import com.example.common.util.ext.navigateTo
import com.example.lib_data_source.network.source.Resource
import com.example.template_v2.feature_one.api.FeatureOneRouteConstant
import com.example.template_v2.main.R
import com.example.template_v2.main.api.MainRouterConstant
import com.example.template_v2.main.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Route(path = MainRouterConstant.Activity.PATH_LOGIN)
class LoginActivity : LifecycleActivity<LoginViewModel>(
    R.layout.activity_login,
    LoginViewModel::class.java
) {

    private val binding by viewBinding(ActivityLoginBinding::bind)

    override fun initViews() {
    }

    override fun initListeners() {
        binding.btnLogin.click {
            viewModel.test.observe(this, {
                when (it) {
                    is Resource.Success -> {
                        moveToTargetedScreen()
                    }
                    is Resource.Loading -> {
                        Log.e("", "")
                    }
                    is Resource.Failed -> {
                        Log.e("", "")
                    }
                }
            })
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
}