package com.ns.mvvmnews.mvvmnews.model

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: MutableList<Article>
) {
}