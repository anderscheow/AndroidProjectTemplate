package com.example.template_v2.main.main

import by.kirich1409.viewbindingdelegate.viewBinding
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.base.activity.LifecycleActivity
import com.example.template_v2.main.R
import com.example.template_v2.main.api.MainRouterConstant
import com.example.template_v2.main.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Route(path = MainRouterConstant.Activity.PATH_MAIN)
class MainActivity : LifecycleActivity<MainViewModel>(
    R.layout.activity_main,
    MainViewModel::class.java
) {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun initViews() {
    }

    override fun initListeners() {
    }
}