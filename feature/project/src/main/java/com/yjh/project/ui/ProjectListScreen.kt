package com.yjh.project.ui

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectListScreen(cid: Int) {

    val viewModelKey = "${ProjectListViewModel::class.java.canonicalName}-cid=$cid"
    val viewModel = viewModel<ProjectListViewModel>(key = viewModelKey, factory = viewModelFactory {
        addInitializer(ProjectListViewModel::class) {
            ProjectListViewModel(cid)
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
                Surface(
                    onClick = {},
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    ProjectItem(
                        userName = item.author,
                        date = it.niceDate,
                        title = it.title,
                        content = it.desc
                    )
                }
            }
        }
    }
}


