package com.yjh.main.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun HomeItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFECEEF2), shape = RoundedCornerShape(10.dp))
            .padding(10.dp)
    ) {


        Row() {
            Text(
                text = "扔无线", fontSize = 14.sp,
                color = Color.Black
            )

            Text(
                text = "置顶",
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 14.sp,
                color = Color.Red
            )

            Text(
                text = "新",
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 14.sp,
                color = Color.Red
            )

            Text(
                text = "本站发布",
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 14.sp,
                color = Color.Green
            )

            Text(
                text = "问答",
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 14.sp,
                color = Color.Green
            )

            Spacer(modifier = Modifier.weight(1f, true))

            Text(
                text = "刚刚",
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 14.sp,
                color = Color.Black
            )

        }
        Text(
            text = "《扔物线》超级618，爆燃开启！",
            fontSize = 14.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 5.dp)
        )


        Text(
            text = "干货资源-课程推荐",
            fontSize = 14.sp,
            color = Color.Black
        )
    }

}