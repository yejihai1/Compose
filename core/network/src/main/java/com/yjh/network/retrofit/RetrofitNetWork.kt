package com.yjh.network.retrofit


import android.util.Log
import com.yjh.network.NetworkDataSource
import com.yjh.network.model.BaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BaseUrl = "https://www.wanandroid.com"

private val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) })
    .build()

private val networkApi = Retrofit.Builder()
    .baseUrl(BaseUrl)
    .client(okHttpClient)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
    .create(RetrofitNetworkApi::class.java)


suspend fun <T> launchRequest(request: suspend RetrofitNetworkApi.() -> BaseResponse<T>?): Flow<BaseResponse<T>> {
    return flow {
        val response =
            request(networkApi) ?: throw IllegalArgumentException("数据非法，获取响应数据为空")
        emit(response)
    }.flowOn(Dispatchers.IO)
}