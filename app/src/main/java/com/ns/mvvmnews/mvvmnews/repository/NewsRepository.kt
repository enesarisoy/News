package com.ns.mvvmnews.mvvmnews.repository

import com.ns.mvvmnews.mvvmnews.api.RetrofitInstance
import com.ns.mvvmnews.mvvmnews.data.ArticleDatabase
import com.ns.mvvmnews.mvvmnews.model.Article

class NewsRepository(
    val db: ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().delete(article)
}