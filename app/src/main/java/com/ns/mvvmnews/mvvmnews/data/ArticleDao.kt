package com.ns.mvvmnews.mvvmnews.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ns.mvvmnews.mvvmnews.model.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>   //it's not suspend cuz livedata is already asynchronous

    @Delete
    suspend fun delete(article: Article)
}