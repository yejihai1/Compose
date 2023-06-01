package com.yjh.main.ui

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.yjh.ui.base.BaseViewModel


class QuestionViewModel : BaseViewModel() {

    val getData by lazy {
        Pager(PagingConfig(1)) {
            QuestionPagingSource()
        }.flow
    }

    override fun initThat() {

    }

}