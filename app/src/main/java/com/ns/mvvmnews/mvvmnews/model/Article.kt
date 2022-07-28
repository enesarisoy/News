package com.ns.mvvmnews.mvvmnews.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "articles")
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,    //not every article will have an id
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?,
    val source: Source?  //source is a class. not primitive data type. so u have to use typeconverter
) : Serializable    //if u want to pass data to another fragment navigation args u have to : serializable
                    //actually, u should use parcelable instead of serializable, I'll do another day
{
    override fun hashCode(): Int {
        var result = id.hashCode()
        if(url.isNullOrEmpty()){
            result = 31 * result + url.hashCode()
        }
        return result
    }
}
