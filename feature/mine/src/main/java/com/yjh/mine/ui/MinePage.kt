package com.yjh.mine.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yjh.mine.R

@Preview
@Composable
fun MinePage() {

    Column() {

        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.height(200.dp)
        ) {

            Image(
                modifier = Modifier.padding(10.dp),
                painter = painterResource(id = R.mipmap.icon_user_default),
                contentDescription = "头像"
            )

            Column() {
                Text(text = "未登陆", fontWeight = FontWeight.Bold)
                Text(text = "id")
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "积分: 0 等级: 0 排名: 0 ")

                    Image(
                        painter = painterResource(id = R.mipmap.icon_arrow_right),
                        contentDescription = "arrow",
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .width(15.dp)
                            .height(15.dp)
                    )
                }

            }

        }

        Box() {


            Column(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        Color(0xFFECEEF2),
                        shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                    )
                    .padding(top = 15.dp)
            ) {
                MinePageItem("消息中心", R.mipmap.icon_message) {

                }
                MinePageItem("分享文章", R.mipmap.icon_share) {}
                MinePageItem("收藏文章", R.mipmap.icon_like) {}
                MinePageItem("工具列表", R.mipmap.icon_tools) {}
            }

            Row {
                Spacer(modifier = Modifier.weight(1f))
                FloatingActionButton(modifier = Modifier
                    .padding(end = 10.dp)
                    .width(60.dp)
                    .height(60.dp), onClick = { }
                ) {
                    Text(text = "设置")
                }
            }


        }
    }
}

@Composable
fun MinePageItem(
    title: String = "title",
    @DrawableRes resId: Int = 0,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Image(
            painter = painterResource(id = resId),
            contentDescription = "image",
            modifier = Modifier
                .padding(start = 10.dp)
                .width(30.dp)
                .height(30.dp)

        )
        Text(
            text = title,
            modifier = Modifier.padding(horizontal = 10.dp),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1.0f))
        Image(
            painter = painterResource(id = R.mipmap.icon_arrow_right),
            contentDescription = "arrow",
            modifier = Modifier
                .padding(end = 10.dp)
                .width(25.dp)
                .height(25.dp)
        )
    }
}