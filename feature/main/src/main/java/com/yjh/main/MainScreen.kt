package com.yjh.main

import QuestionPage
import SquarePage
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yjh.main.ui.MainPage
import com.yjh.main.ui.MainViewModel
import com.yjh.main.ui.QuestionViewModel
import com.yjh.main.ui.SquareViewModel
import kotlinx.coroutines.launch

enum class MainPages(
    val title: String,
) {
    MAIN("首页"),
    SQUARE("广场"),
    QUESTION("问答")
}

@OptIn( ExperimentalFoundationApi::class)
@Composable
fun MainScreen(pages: Array<MainPages> = MainPages.values()) {

    val coroutineScope = rememberCoroutineScope()
    val pageState = rememberPagerState()

    Column(modifier = Modifier.padding(top = 20.dp)) {
        TabRow(pageState.currentPage) {
            pages.forEach {
                Tab(pageState.currentPage == it.ordinal, onClick = {
                    coroutineScope.launch {
                        pageState.animateScrollToPage(it.ordinal)
                    }
                }) {

                    Column(
                        modifier = Modifier.height(50.dp), verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = it.title,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }


        val mainModel = viewModel<MainViewModel>()
        val squareModel = viewModel<SquareViewModel>()
        val questionModel = viewModel<QuestionViewModel>()

        HorizontalPager(
            pageCount = pages.size, modifier = Modifier
                .fillMaxWidth()
                .weight(1f, true),
            state = pageState
        ) { index ->
            when (pages[index]) {
                MainPages.MAIN -> {
                    MainPage(viewModel = mainModel)
                }

                MainPages.SQUARE -> {
                    SquarePage(viewModel = squareModel)
                }

                MainPages.QUESTION -> {
                    QuestionPage(viewModel = questionModel)
                }
            }

        }
    }


}