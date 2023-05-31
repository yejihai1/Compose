package com.yjh.main.ui

import com.yjh.main.BaseViewModel
import com.yjh.network.model.Article
import com.yjh.network.retrofit.launchRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

class QuestionViewModel : BaseViewModel() {


    private val _questionArticleListData: MutableStateFlow<MutableList<Article>> =
        MutableStateFlow(mutableListOf())
    val questionArticleListData: StateFlow<MutableList<Article>> =
        _questionArticleListData.asStateFlow()


    private fun getQAArticleList(pageNum: Int) {
        async {
            launchRequest { this.getQAArticleList(pageNum) }.map {
                it.data.datas
            }.collect {
                _questionArticleListData.value = it
            }
        }
    }

    override fun start() {
        initThat {
            getQAArticleList(0)
        }
    }
}