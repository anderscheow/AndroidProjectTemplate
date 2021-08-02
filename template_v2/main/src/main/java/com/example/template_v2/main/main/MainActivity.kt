package com.example.template_v2.main.main

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.template_v2.main.api.MainRouterConstant
import com.example.template_v2.main.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Route(path = MainRouterConstant.Activity.PATH_MAIN)
class MainActivity : com.example.common.base.activity.LifecycleActivity<MainViewModel>(MainViewModel::class.java) {

    private lateinit var binding: ActivityMainBinding

    override fun getViewBinding(): View {
        return ActivityMainBinding.inflate(layoutInflater).run {
            binding = this
            this.root
        }
    }

    override fun initViews() {
    }

    override fun initListeners() {
    }
}