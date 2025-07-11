package com.loc.newsapp.presentation.details

import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.usecases.app_entry.news.SelectArticle

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()
}