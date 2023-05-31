package com.yjh.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjh.network.model.Article
import com.yjh.network.retrofit.launchRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val articleListData_: MutableSharedFlow<MutableList<Article>> = MutableSharedFlow()
    val articleListData: SharedFlow<MutableList<Article>> = articleListData_.asSharedFlow()

    fun getArticleList(pageNum: Int) {
        viewModelScope.launch(Dispatchers.Main) {

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
                articleListData_.emit(it)
            }

        }

    }
}