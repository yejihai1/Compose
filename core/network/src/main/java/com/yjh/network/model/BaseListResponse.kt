package com.yjh.network.model

data class BaseListResponse<T>(
    val curPage: Int,
    val datas: T,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)
