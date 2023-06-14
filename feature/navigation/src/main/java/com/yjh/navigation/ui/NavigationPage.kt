package com.yjh.navigation.ui

import android.util.Log
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yjh.ui.widget.AutoLayout
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Preview
@Composable
fun NavigationPage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val viewModel = viewModel<NavigationViewModel>()
        val data by viewModel.navigationTreeData.collectAsState()
        viewModel.start()

        var animateState by remember {
            mutableStateOf(false)
        }

        val coroutineScope = rememberCoroutineScope()
        val pListState = rememberLazyListState()
        val sListState = rememberLazyListState()
        var currentIndex by remember {
            mutableStateOf(0)
        }
        LaunchedEffect(sListState) {

            snapshotFlow { sListState.firstVisibleItemIndex }
                .collect {
                    if(!animateState){
                        currentIndex = it
                        val target = if (currentIndex >= 8) {
                            currentIndex - 8
                        } else 0
                        pListState.animateScrollToItem(target)
                    }
                }
        }

        LaunchedEffect(sListState){

            snapshotFlow {
                sListState.isScrollInProgress
            }.collect {
                if (!sListState.isScrollInProgress) {
                    animateState = false
                }
            }
        }



        Row(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                state = pListState,
                modifier = Modifier
                    .wrapContentWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(
                    start = 10.dp, top = 10.dp, end = 10.dp, bottom = 80.dp
                )
            ) {


                itemsIndexed(data) { index, it ->
                    TextItem(index == currentIndex, it.name, onClick = {
                        animateState = true
                        currentIndex = index
                        coroutineScope.launch {
                            val target = if (index >= 8) {
                                index - 8
                            } else 0
                            pListState.animateScrollToItem(target)
                            sListState.animateScrollToItem(index)
                        }
                    })
                }
            }

            LazyColumn(
                state = sListState,
                modifier = Modifier
                    .weight(1.0f, true)
                    .fillMaxHeight(),
                contentPadding = PaddingValues(
                    bottom = 80.dp
                )
            ) {

                itemsIndexed(data) { index, it ->
                    Column {
                        Text(
                            text = it.name ?: "",
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.Bold
                        )
                        AutoLayout {
                            it.articles?.forEach {
                                SubTextItem(title = it.title)
                            }
                        }
                    }
                }

            }
        }


    }
}