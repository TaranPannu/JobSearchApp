package com.example.jobsearch.Room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromString(value: String): List<String> {
     var l = listOf<String>(value)
        return l
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        return list[0]
    }
}
