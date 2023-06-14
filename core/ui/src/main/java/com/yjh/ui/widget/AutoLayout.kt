package com.yjh.ui.widget

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable


@Composable
fun AutoLayout(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Layout(modifier = modifier, content = content) { measurables, constraints ->

        //高度
        var height = 0
        //宽度
        val width = constraints.maxWidth
        //记录每一行 行宽
        var lineWidth = 0
        val map = hashMapOf<Int, MutableList<Placeable>>()

        var lineIndex = 0

        measurables.forEachIndexed { index, it ->
            val placeable = it.measure(constraints)
            //计算高度
            if (index == 0) {
                height += placeable.height
            }
            if (lineWidth + placeable.width > width) {
                height += placeable.height
                lineWidth = placeable.width
                lineIndex++
            } else {
                lineWidth += placeable.width
            }

            map[lineIndex]?.add(placeable) ?: run {
                map[lineIndex] = mutableListOf<Placeable>().apply { add(placeable) }
            }
        }

        layout(width, height) {
            map.forEach { (index, placeables) ->
                var xPosition = 0
                placeables.forEach {
                    val yPosition = index * it.height
                    it.placeRelative(xPosition, yPosition)
                    xPosition += it.width
                }
            }
        }
    }
}