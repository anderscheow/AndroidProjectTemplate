package com.example.lib_data_source.room.converters

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.lib_data_source.util.MoshiUtil
import com.example.lib_data_source.util.RoomConverterUtil

@TypeConverters
object GeneralConverters {

    //region [String]
    @TypeConverter
    fun toStrings(json: String?): List<String>? {
        return RoomConverterUtil.doNullCheck(json) {
            MoshiUtil.getListJsonAdapter(String::class.java).fromJson(json!!)
        }
    }

    @TypeConverter
    fun fromStrings(data: List<String>?): String? {
        return RoomConverterUtil.doNullCheck(data) {
            MoshiUtil.getListJsonAdapter(String::class.java).toJson(data)
        }
    }
    //endregion

    //region [Int]
    @TypeConverter
    fun toInts(json: String?): List<Int>? {
        return RoomConverterUtil.doNullCheck(json) {
            MoshiUtil.getListJsonAdapter(Int::class.java).fromJson(json!!)
        }
    }

    @TypeConverter
    fun fromInts(data: List<Int>?): String? {
        return RoomConverterUtil.doNullCheck(data) {
            MoshiUtil.getListJsonAdapter(Int::class.java).toJson(data)
        }
    }
    //endregion

    //region [Long]
    @TypeConverter
    fun toLongs(json: String?): List<Long>? {
        return RoomConverterUtil.doNullCheck(json) {
            MoshiUtil.getListJsonAdapter(Long::class.javaObjectType).fromJson(json!!)
        }
    }

    @TypeConverter
    fun fromLongs(data: List<Long>?): String? {
        return RoomConverterUtil.doNullCheck(data) {
            MoshiUtil.getListJsonAdapter(Long::class.javaObjectType).toJson(data)
        }
    }
    //endregion

    //region [Boolean]
    @TypeConverter
    fun toBooleans(json: String?): List<Boolean>? {
        return RoomConverterUtil.doNullCheck(json) {
            MoshiUtil.getListJsonAdapter(Boolean::class.java).fromJson(json!!)
        }
    }

    @TypeConverter
    fun fromBooleans(data: List<Boolean>?): String? {
        return RoomConverterUtil.doNullCheck(data) {
            MoshiUtil.getListJsonAdapter(Boolean::class.java).toJson(data)
        }
    }
    //endregion
}