package com.yjh.main.ui

import com.yjh.main.BaseViewModel
import com.yjh.network.model.Article
import com.yjh.network.retrofit.launchRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.zip

class MainViewModel : BaseViewModel() {

    private val _articleListData: MutableStateFlow<MutableList<Article>> = MutableStateFlow(
        mutableListOf()
    )
    val articleListData: StateFlow<MutableList<Article>> = _articleListData.asStateFlow()

    private fun getArticleList(pageNum: Int) {
        async {
            val flow1 =
                launchRequest { this.getTopArticle() }.map { it.data }
            val flow2 =
                launchRequest { this.getArticleList(pageNum) }.map { it.data.datas }

            if (pageNum == 0) {
                flow2.zip(flow1) { a, b ->
                    mutableListOf<Article>().apply {
                        addAll(b)
                        addAll(a)
                    }
                }
            } else {
                flow2
            }.collect {
                _articleListData.value = it
            }

        }

    }

    override fun start() {
        initThat {
            getArticleList(0)
        }
    }
}