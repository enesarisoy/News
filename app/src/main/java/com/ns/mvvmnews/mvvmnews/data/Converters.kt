package com.ns.mvvmnews.mvvmnews.data

import androidx.room.TypeConverter
import com.ns.mvvmnews.mvvmnews.model.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}