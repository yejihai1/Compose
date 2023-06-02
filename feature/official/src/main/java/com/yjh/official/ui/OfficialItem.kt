package com.yjh.official.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfficialItem(userName: String = "userName", date: String = "date", title: String = "title") {

    Surface(
        onClick = {},
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(bottom = 10.dp),
        color = Color(0xFFECEEF2)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Row() {
                Text(text = userName, fontSize = 14.sp)
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "公众号",
                    fontSize = 14.sp,
                    color = Color.Green,
                )
                Spacer(modifier = Modifier.weight(1.0f, true))

                Text(text = date, fontSize = 14.sp)
            }

            Text(
                text = title,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 5.dp),
                fontWeight = FontWeight.Bold
            )

            Text(text = "公众号·${userName}", fontSize = 14.sp)
        }
    }

}