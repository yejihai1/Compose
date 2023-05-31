package com.yjh.main.ui


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun MainPage(viewModel: MainViewModel) {
    viewModel.start()
    val state = viewModel.articleListData.collectAsState(initial = mutableListOf())
    ListItem(state)
}