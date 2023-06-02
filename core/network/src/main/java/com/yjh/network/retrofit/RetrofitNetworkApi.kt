package com.yjh.network.retrofit

import com.yjh.network.model.Article
import com.yjh.network.model.BaseListResponse
import com.yjh.network.model.BaseResponse
import com.yjh.network.model.Project
import com.yjh.network.model.ProjectItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitNetworkApi {
    @GET("article/list/{page}/json")
    suspend fun getArticleList(@Path("page") page: Int): BaseResponse<BaseListResponse<MutableList<Article>>>

    @GET("article/top/json")
    suspend fun getTopArticle(): BaseResponse<MutableList<Article>>

    @GET("wenda/list/{page}/json")
    suspend fun getQAArticleList(@Path("page") page: Int): BaseResponse<BaseListResponse<MutableList<Article>>>

    @GET("user_article/list/{page}/json")
    suspend fun getSquareArticleList(@Path("page") page: Int): BaseResponse<BaseListResponse<MutableList<Article>>>

    @GET("project/tree/json")
    suspend fun getProjectTree(): BaseResponse<MutableList<Project>>

    @GET("project/list/{page}/json")
    suspend fun getProjectList(
        @Path("page") page: Int,
        @Query("cid") cid: Int
    ): BaseResponse<BaseListResponse<MutableList<ProjectItem>>>


    @GET("wxarticle/chapters/json")
    suspend fun getWxArticleTree(): BaseResponse<MutableList<Project>>


    @GET("wxarticle/list/{cid}/{page}/json")
    suspend fun getWxArticleList(
        @Path("page") page: Int,
        @Path("cid") cid: Int
    ): BaseResponse<BaseListResponse<MutableList<Article>>>


}
