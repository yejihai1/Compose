package com.yjh.network.model

data class SystemData(
    val name: String? = "",
    val id: Int? = 0,
    val children: MutableList<ProjectData>? = mutableListOf()
)