package com.loc.newsapp.presentation.onboarding

import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.loc.newsapp.presentation.onboarding.Dimens.MediumPadding2
import com.loc.newsapp.presentation.onboarding.components.OnBoardingPage
import com.loc.newsapp.presentation.onboarding.components.PageIndicator

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(){
    Column(modifier = Modifier.fillMaxSize()){
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }
        val buttonState = remember{
            derivedStateOf {
                when(pagerState.currentPage){
                    0 -> listOf(" ","Next")
                    1 -> listOf("Back","Next")
                    2 -> listOf("Back","Get Started")
                    else -> listOf(" "," ")
                }
            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            PageIndicator(modifier = Modifier.width(52.dp), pageSize = pages.size, selectedPage = pagerState.currentPage)
        }
    }


}