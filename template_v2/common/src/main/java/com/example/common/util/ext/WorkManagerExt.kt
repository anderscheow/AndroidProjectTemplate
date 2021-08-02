package com.example.common.util.ext

import androidx.work.CoroutineWorker

fun CoroutineWorker.hasExceedRetry(): Boolean =
    runAttemptCount > 2