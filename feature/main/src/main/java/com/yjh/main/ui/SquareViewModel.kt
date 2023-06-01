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
import kotlinx.coroutines.flow.map

class SquareViewModel : BaseViewModel() {


    val getData by lazy {
        Pager(PagingConfig(1)) {
            SquarePagingSource()
        }.flow
    }

    override fun start() {
//        initThat {
//            getSquareArticleList(0)
//        }
    }
}