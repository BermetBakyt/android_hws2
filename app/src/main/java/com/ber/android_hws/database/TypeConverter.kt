package com.ber.android_hws.database

import androidx.room.TypeConverter
import com.google.gson.Gson

class TypeConverter {

    @TypeConverter
    fun listToJson(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()
}