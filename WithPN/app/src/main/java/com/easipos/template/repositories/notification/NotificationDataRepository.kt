package com.easipos.template.repositories.notification

import com.easipos.template.api.requests.notification.RegisterFcmTokenRequestModel
import com.easipos.template.api.requests.notification.RemoveFcmTokenRequestModel
import com.easipos.template.datasource.DataFactory
import com.easipos.template.models.Result

class NotificationDataRepository(private val dataFactory: DataFactory) : NotificationRepository {

    override suspend fun registerFcmToken(model: RegisterFcmTokenRequestModel): Result<Nothing> =
        dataFactory.createNotificationDataSource()
            .registerFcmToken(model)

    override suspend fun removeFcmToken(model: RemoveFcmTokenRequestModel): Result<Nothing> =
        dataFactory.createNotificationDataSource()
            .removeFcmToken(model)
}