package com.example.template_v2.feature_one.api.work_manager

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import javax.inject.Inject

class ConnectWorkerFactory @Inject constructor(
//    private val iVideoRepository: Lazy<IVideoRepository>
) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when (workerClassName) {
//            UploadVideoWorker::class.java.name -> {
//                UploadVideoWorker(appContext, workerParameters, iVideoRepository.get())
//            }

            else -> null
        }
    }
}