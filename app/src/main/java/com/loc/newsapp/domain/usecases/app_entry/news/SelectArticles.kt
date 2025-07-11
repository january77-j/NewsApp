package com.loc.newsapp.domain.usecases.app_entry.news

import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsDao: NewsRepository
) {
    operator fun invoke(): Flow<List<Article>> {
        return newsDao.selectArticles()
    }
}