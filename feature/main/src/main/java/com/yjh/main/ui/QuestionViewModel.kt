package com.yjh.main.ui

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.yjh.ui.base.BaseViewModel


class QuestionViewModel : BaseViewModel() {

    val getData by lazy {
        Pager(PagingConfig(1)) {
            QuestionPagingSource()
        }.flow.cachedIn(viewModelScope)
    }

    override fun initThat() {

    }

}