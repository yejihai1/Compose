package com.yjh.project

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yjh.project.ui.ProjectListScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun ProjectScreen() {

    val viewModel = viewModel<ProjectViewModel>()
    val pages by viewModel.projectListData.collectAsState()
    viewModel.start()

    val pageState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    if (pages.isNotEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(modifier = Modifier.padding(top = 20.dp)) {
                ScrollableTabRow(
                    pageState.currentPage, modifier = Modifier.wrapContentWidth(),
                    edgePadding = 5.dp
                ) {
                    pages.forEachIndexed { index, project ->
                        Tab(
                            pageState.currentPage == index,
                            modifier = Modifier.wrapContentWidth(),
                            onClick = {
                                coroutineScope.launch {
                                    pageState.animateScrollToPage(index)
                                }
                            }) {
                            Column(
                                modifier = Modifier.height(50.dp),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = project.name,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }

                HorizontalPager(
                    pageCount = pages.size, modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, true),
                    state = pageState,
                    key = {
                        it
                    }
                ) { index ->
                    ProjectListScreen(pages[index].id)
                }
            }
        }
    }


}

