package com.easipos.template.repositories.notification

import com.easipos.template.api.requests.notification.RegisterFcmTokenRequestModel
import com.easipos.template.api.requests.notification.RemoveFcmTokenRequestModel
import com.easipos.template.models.Result

interface NotificationRepository {

    suspend fun registerFcmToken(model: RegisterFcmTokenRequestModel): Result<Nothing>

    suspend fun removeFcmToken(model: RemoveFcmTokenRequestModel): Result<Nothing>
}
