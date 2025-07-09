package com.loc.newsapp.presentation.details

import com.loc.newsapp.presentation.nvgraph.Route

sealed class DetailsEvent {
    object SaveArticle : DetailsEvent()
}