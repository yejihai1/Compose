package com.yjh.main.ui


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage() {
    val viewModel = viewModel<MainViewModel>()
    viewModel.start()
    val data = viewModel.getData.collectAsLazyPagingItems()

    ListItem(data = data)
}