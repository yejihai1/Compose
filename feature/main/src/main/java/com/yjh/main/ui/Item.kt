package com.yjh.main.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeItem(
    userName: String = "扔无线",
    date: String = "刚刚",
    title: String = "《扔物线》超级618，爆燃开启！",
    chapterName: String = "干货资源·课程推荐",
    onClick: () -> Unit = {}
) {

    Surface(
        onClick = onClick,
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFECEEF2), shape = RoundedCornerShape(10.dp))
                .padding(10.dp)
        ) {


            Row {
                Text(
                    text = userName, fontSize = 14.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.weight(1f, true))

                Text(
                    text = date,
                    modifier = Modifier.padding(start = 10.dp),
                    fontSize = 14.sp,
                    color = Color.Black
                )

            }
            Text(
                text = title,
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 5.dp)
            )


            Text(
                text = chapterName,
                fontSize = 14.sp,
                color = Color.Black
            )
        }
    }

}