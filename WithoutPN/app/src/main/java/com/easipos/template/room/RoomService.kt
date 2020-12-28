package com.easipos.template.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.easipos.template.models.Notification

@Database(
        entities = [
                Notification::class
        ],
        version = 1,
        exportSchema = true
)
@TypeConverters(Converters::class)
abstract class RoomService : RoomDatabase() {

        abstract fun notificationDao(): NotificationDao
}
