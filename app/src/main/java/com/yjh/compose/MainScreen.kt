package com.yjh.compose

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

val title = listOf("主页", "项目", "导航", "朋友", "我的")


@Preview
@Composable
fun MainScreen() {
    val context = LocalContext.current
    val page = remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, true)
                .background(Color.Yellow),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "当前页面是：${title[page.value]}",
                modifier = Modifier.wrapContentSize(),
                textAlign = TextAlign.Center
            )
        }

        NavigationBar(
            modifier = Modifier
                .wrapContentHeight()
        ) {
            for (index in 0..4) {
                val isSelected = page.value == index
                NavigationBarItem(
                    selected = isSelected,
                    icon = {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = title[index])
                        }
                    },
                    onClick = {

                        page.value = index
//                        Toast.makeText(context, "当前位置：$index", Toast.LENGTH_SHORT).show()
                    })
            }
        }

    }

}