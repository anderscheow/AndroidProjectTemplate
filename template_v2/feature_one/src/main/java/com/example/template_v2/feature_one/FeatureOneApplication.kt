package com.example.template_v2.feature_one

import androidx.work.Configuration
import androidx.work.WorkerFactory
import com.example.template_v2.feature_one.api.work_manager.ConnectWorkerFactory
import com.toga.chat.main.MainApplication
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class FeatureOneApplication : MainApplication(), Configuration.Provider {

    @Inject
    lateinit var connectWorkerFactory: ConnectWorkerFactory

    override fun getWorkerFactories(): List<WorkerFactory> {
        return listOf(connectWorkerFactory)
    }
}