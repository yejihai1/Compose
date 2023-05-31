package com.yjh.main.ui

import com.yjh.main.BaseViewModel
import com.yjh.network.model.Article
import com.yjh.network.retrofit.launchRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

class SquareViewModel : BaseViewModel() {

    private val _squareArticleListData: MutableStateFlow<MutableList<Article>> =
        MutableStateFlow(mutableListOf())
    val squareArticleListData: StateFlow<MutableList<Article>> =
        _squareArticleListData.asStateFlow()


    private fun getSquareArticleList(pageNum: Int) {
        async {
            launchRequest { this.getSquareArticleList(pageNum) }.map {
                it.data.datas
            }.collect {
                _squareArticleListData.value = it
            }
        }
    }

    override fun start() {
        initThat {
            getSquareArticleList(0)
        }
    }
}