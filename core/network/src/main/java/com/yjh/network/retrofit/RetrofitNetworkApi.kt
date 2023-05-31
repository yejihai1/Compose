package com.yjh.network.retrofit

import com.yjh.network.model.Article
import com.yjh.network.model.BaseListResponse
import com.yjh.network.model.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitNetworkApi {
    @GET("article/list/{page}/json")
    suspend fun getArticleList(@Path("page") page: Int): BaseResponse<BaseListResponse<MutableList<Article>>>


    @GET("article/top/json")
    suspend fun getTopArticle(): BaseResponse<MutableList<Article>>
}