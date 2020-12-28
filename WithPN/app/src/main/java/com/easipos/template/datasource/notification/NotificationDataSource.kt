package com.easipos.template.datasource.notification

import com.easipos.template.api.misc.parseException
import com.easipos.template.api.misc.parseResponse
import com.easipos.template.api.requests.notification.RegisterFcmTokenRequestModel
import com.easipos.template.api.requests.notification.RemoveFcmTokenRequestModel
import com.easipos.template.api.services.Api
import com.easipos.template.models.Result

class NotificationDataSource(private val api: Api) : NotificationDataStore {

    override suspend fun registerFcmToken(model: RegisterFcmTokenRequestModel): Result<Nothing> {
        return try {
            val response = api.registerFcmToken(model.toFormDataBuilder().build())
            parseResponse(response)
        } catch (ex: Exception) {
            parseException(ex)
        }
    }

    override suspend fun removeFcmToken(model: RemoveFcmTokenRequestModel): Result<Nothing> {
        return try {
            val response = api.removeFcmToken(model.toFormDataBuilder().build())
            parseResponse(response)
        } catch (ex: Exception) {
            parseException(ex)
        }
    }
}
