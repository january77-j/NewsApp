package com.loc.newsapp.presentation.details

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.util.TableInfo
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.loc.newsapp.R
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.model.Source
import com.loc.newsapp.presentation.details.components.DetailsTopBar
import com.loc.newsapp.presentation.nvgraph.Route
import com.loc.newsapp.presentation.onboarding.Dimens.ArticleImageHeight
import com.loc.newsapp.presentation.onboarding.Dimens.MediumPadding1
import com.loc.newsapp.ui.theme.NewsAppTheme

@Composable
fun DetailsScreen(
    article: Article,
    event: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        DetailsTopBar(
            onBrowsingClick = {
                Intent(Intent.ACTION_VIEW).also {
                    it.data = Uri.parse(article.url)
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, article.url)
                    it.type = "text/plain"
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onBookmarkClick = { event(DetailsEvent.SaveArticle) },
            onBackClick = navigateUp
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = MediumPadding1,
                end = MediumPadding1,
                top = MediumPadding1
            )
        ) {
            item {

                AsyncImage(
                    model = ImageRequest.Builder(context = context).data(article.urlToImage)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ArticleImageHeight)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(MediumPadding1))

                Text(
                    text = article.title,
                    style = MaterialTheme.typography.displaySmall,
                    color = colorResource(
                        id = R.color.text_title
                    )
                )
                Text(
                    text = article.content,
                    style = MaterialTheme.typography.displaySmall,
                    color = colorResource(
                        id = R.color.body
                    )
                )

            }


        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DetailsScreenPreview() {
    NewsAppTheme {
        DetailsScreen(
            article = Article(
                author = "王大明",
                content = "這是一段繁體中文的新聞內容，用來測試預覽畫面顯示效果。內容可以是新聞內文的摘要，或是詳細報導的一部分。",
                description = "這是一則測試用的新聞描述。",
                publishedAt = "2025-07-07T12:00:00Z",
                source = Source(id = "1", name = "自由時報"),
                title = "台灣科技業再創高峰：AI 晶片出口創新高",
                url = "https://www.example.com/news/123",
                urlToImage = "https://via.placeholder.com/600x400.png?text=新聞圖片"
            ),
            event = {}, // 傳入空 lambda，代表不觸發任何事件
            navigateUp = {} // 傳入空 lambda，模擬返回行為
        )
    }
}
