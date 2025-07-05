package com.loc.newsapp.presentation.onboarding

import android.icu.text.CaseMap.Title
import android.icu.text.CaseMap.toTitle
import android.util.EventLogTags.Description
import androidx.annotation.DrawableRes

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int

)


val pages = listOf(
    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboarding1
    )
    Page(
    title = "Lorem Ipsum is simply dummy",
    description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    image = R.drawable.onboarding2
    )
    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.onboarding3
    )
)