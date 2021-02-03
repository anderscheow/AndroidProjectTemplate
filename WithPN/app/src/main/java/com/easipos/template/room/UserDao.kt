package com.easipos.template.room

import androidx.paging.DataSource
import androidx.room.*
import com.easipos.template.models.Notification
import com.easipos.template.models.UserInfo

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserInfo(userInfo: UserInfo)

    @Query("SELECT * FROM UserInfo LIMIT 1")
    fun findUserInfo(): UserInfo?

    @Update
    fun updateUserInfo(userInfo: UserInfo)
}