package com.yjh.navigation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TextItem(isSelect: Boolean = false, name: String? = "name", onClick: () -> Unit = {}) {
    Surface(
        onClick = onClick,
        modifier = Modifier
            .padding(bottom = 5.dp)
            .width(80.dp)
            .height(30.dp),
        shape = RoundedCornerShape(15.dp),
        color = if (isSelect) Color(0xFF8BBBA6) else Color(0xFFE0E1E5)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            Arrangement.Center, Alignment.CenterHorizontally
        ) {
            Text(
                text = name ?: "",
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}