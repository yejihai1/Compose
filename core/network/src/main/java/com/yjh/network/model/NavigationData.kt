package com.yjh.network.model

data class NavigationData(
    val cid: String? = "",
    val name: String? = "",
    val articles: MutableList<Article>? = mutableListOf()
)
