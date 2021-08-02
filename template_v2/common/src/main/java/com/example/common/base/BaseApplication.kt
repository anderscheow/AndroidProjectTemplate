package com.example.common.base

import android.app.Application
import androidx.work.WorkManager
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.example.common.BuildConfig
import dagger.Lazy
import javax.inject.Inject

abstract class BaseApplication : Application() {

    @Inject
    lateinit var workManager: Lazy<WorkManager>

    override fun onCreate() {
        super.onCreate()
        initRouter()
        initLogger()
        pruneWorkManagerRequest()
    }

    override fun onTerminate() {
        ARouter.getInstance().destroy()
        super.onTerminate()
    }

    private fun initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    private fun initLogger() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)
            .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }

    private fun pruneWorkManagerRequest() {
        workManager.get().pruneWork()
    }
}