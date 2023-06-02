package com.yjh.official.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items

@Composable
fun OfficialListScreen(cid: Int) {
    val viewModelKey = "${OfficialListViewModel::class.java.canonicalName}-cid=$cid"
    val viewModel =
        viewModel<OfficialListViewModel>(key = viewModelKey, factory = viewModelFactory {
            addInitializer(OfficialListViewModel::class) {
                OfficialListViewModel(cid)
            }
        })
    viewModel.start()

    val data = viewModel.getData.collectAsLazyPagingItems()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(
            start = 10.dp,
            top = 10.dp,
            end = 10.dp,
            bottom = 80.dp
        )
    ) {
        items(items = data) { item ->
            item?.let {
                OfficialItem(
                    userName = item.author,
                    date = it.niceDate,
                    title = it.title
                )
            }
        }
    }
}


