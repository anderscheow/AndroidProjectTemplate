package com.easipos.template.room

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.easipos.template.models.Notification

@Dao
interface NotificationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotifications(notifications: List<Notification>)

    @Query("SELECT * FROM Notification ORDER BY indexInResponse ASC")
    fun findNotifications(): DataSource.Factory<Int, Notification>

    @Query("SELECT count(*) FROM Notification")
    fun getNotificationCount(): Long

    @Query("SELECT MAX(indexInResponse) + 1 FROM Notification")
    fun getNextIndexInNotification(): Int

    @Query("DELETE FROM Notification WHERE id = :id")
    fun removeNotification(id: Long)

    @Query("DELETE FROM Notification")
    fun deleteNotificationTable()
}