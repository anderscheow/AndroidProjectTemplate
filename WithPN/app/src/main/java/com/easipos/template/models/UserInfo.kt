package com.easipos.template.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserInfo(
    @PrimaryKey
    val uid: String,
    val name: String,
    val email: String,
    val phoneNumber: String,
)