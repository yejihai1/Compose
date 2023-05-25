package com.yjh.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val state = remember {
            mutableStateOf(false)
        }

        Text(text = "MainScreen", modifier = Modifier.clickable {
            state.value = true
        })

        fun onClick(position: Int){
            state.value = false
        }

        DropdownMenu(expanded = state.value, onDismissRequest = { onClick(0)}) {

            DropdownMenuItem(text = { Text(text = "1") }, onClick = {onClick(0) })
            DropdownMenuItem(text = { Text(text = "2") }, onClick = { onClick(1)})
            DropdownMenuItem(text = { Text(text = "3") }, onClick = { onClick(2)})
            DropdownMenuItem(text = { Text(text = "4") }, onClick = { onClick(3)})
            DropdownMenuItem(text = { Text(text = "5") }, onClick = { onClick(4)})

        }
    }
}