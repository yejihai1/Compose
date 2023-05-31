package com.yjh.network

import com.yjh.network.model.Article
import com.yjh.network.model.BaseListResponse
import com.yjh.network.model.BaseResponse

interface NetworkDataSource {
    suspend fun getArticleList(pageNum: Int): BaseResponse<BaseListResponse<MutableList<Article>>>
}