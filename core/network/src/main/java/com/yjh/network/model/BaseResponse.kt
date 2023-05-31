package com.yjh.network.model

data class BaseResponse<T>(
    val data: T,
    val errorCode: Int,
    val errorMsg: String
)