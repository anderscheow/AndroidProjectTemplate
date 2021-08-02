package com.toga.chat.main

import androidx.work.Configuration
import androidx.work.DelegatingWorkerFactory
import androidx.work.WorkerFactory
import com.example.template_v2.main.api.work_manager.MainWorkerFactory
import com.example.common.base.BaseApplication
import javax.inject.Inject

abstract class MainApplication : com.example.common.base.BaseApplication(), Configuration.Provider {

    @Inject
    lateinit var mainWorkerFactory: MainWorkerFactory

    abstract fun getWorkerFactories(): List<WorkerFactory>

    override fun getWorkManagerConfiguration(): Configuration {
        val workerFactory = DelegatingWorkerFactory().apply {
            this.addFactory(mainWorkerFactory)
            getWorkerFactories().forEach { factory ->
                this.addFactory(factory)
            }
        }

        return Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.INFO)
            .setWorkerFactory(workerFactory)
            .build()
    }
}