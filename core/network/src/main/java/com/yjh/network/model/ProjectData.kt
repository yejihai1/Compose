package com.yjh.network.model

data class ProjectData(
    val name: String = "",
    val courseId: Int = 0,
    val id: Int = 0
)

data class ProjectItemData(
    val title: String = "",
    val desc: String = "",
    val niceDate: String = "",
    val link: String = "",
    val author: String = "",
    val envelopePic: String = "",
)