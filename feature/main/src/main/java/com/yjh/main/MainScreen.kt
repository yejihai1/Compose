package com.yjh.main

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yjh.main.ui.HomeItem

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MainScreen() {

    Column(modifier = Modifier.padding(top = 20.dp)) {
        var curIndex by remember {
            mutableStateOf(0)
        }
        TabRow(curIndex) {
            for (i in 0..2) {
                Tab(curIndex == i, onClick = {
                    curIndex = i
                }) {

                    Column(
                        modifier = Modifier.height(50.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "tab:$i",
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

        }
        val context = LocalContext.current
        LazyColumn(

            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, true),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 80.dp)
        ) {

            for (index in 0..10) {
                item {
                    Surface(
                        onClick = {
                            Toast
                                .makeText(context, "position:${index}", Toast.LENGTH_SHORT)
                                .show()
                            Log.d("test", "postion =$index ")

                        },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        HomeItem()
                    }
                }
            }

        }
    }
}