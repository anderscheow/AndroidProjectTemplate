package com.easipos.template.datasource

import com.easipos.template.api.services.Api
import com.easipos.template.datasource.notification.NotificationDataSource
import com.easipos.template.datasource.notification.NotificationDataStore
import com.easipos.template.datasource.precheck.PrecheckDataSource
import com.easipos.template.datasource.precheck.PrecheckDataStore
import com.easipos.template.datasource.user.UserDataSource
import com.easipos.template.datasource.user.UserDataStore
import com.easipos.template.room.RoomService

class DataFactory(
    private val api: Api,
    private val roomService: RoomService
) {

    fun createPrecheckDataSource(): PrecheckDataStore =
        PrecheckDataSource(api)

    fun createNotificationDataSource(): NotificationDataStore =
        NotificationDataSource(api)

    fun createUserDataSource(): UserDataStore =
        UserDataSource(api, roomService)
}
