package com.example.common.repository

abstract class BaseRepository {

    open fun getPageSize(): Int = 10
}