package com.yjh.main.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yjh.network.model.Article

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListItem(state: State<MutableList<Article>>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 80.dp)
    ) {
        state.value.forEach {
            item(it.id) {
                Surface(
                    onClick = {},
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    HomeItem(
                        userName = it.shareUser,
                        date = it.niceDate,
                        title = it.title,
                        chapterName = "${it.superChapterName}·${it.chapterName}"
                    )
                }
            }
        }
    }
}