package com.yjh.project.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ProjectItem(
    title: String = "title",
    content: String = "content",
    date: String = "date",
    userName: String = "userName",
    imageUrl: String = ""
) {
    Surface(
        onClick = {},
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(10.dp),
        color = Color(0xFFECEEF2)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Surface(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(start = 10.dp),
                color = Color.Gray
            ) {
                AsyncImage(
                    modifier = Modifier
                        .width(100.dp)
                        .height(180.dp),
                    contentScale = ContentScale.Crop,
                    model = imageUrl,
                    contentDescription = "image"
                )
            }
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Bold)

                Text(
                    text = content, fontSize = 14.sp, modifier = Modifier
                        .padding(vertical = 5.dp)
                        .weight(1f, true), overflow = TextOverflow.Ellipsis
                )

                Text(text = "$date $userName", fontSize = 12.sp)
            }

        }

    }
}