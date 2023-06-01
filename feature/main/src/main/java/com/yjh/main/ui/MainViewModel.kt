package com.yjh.main.ui

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.yjh.main.BaseViewModel
import com.yjh.network.model.Article
import com.yjh.network.retrofit.launchRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.zip

class MainViewModel : BaseViewModel() {
    val getData by lazy {
        Pager(PagingConfig(1)) {
            MainPagingSource()
        }.flow
    }

    override fun start() {
//        initThat {
//            getArticleList(0)
//        }
    }
}