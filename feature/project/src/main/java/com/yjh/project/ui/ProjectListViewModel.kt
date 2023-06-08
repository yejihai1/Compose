package com.yjh.project.ui

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.yjh.ui.base.BaseViewModel

class ProjectListViewModel(private val cid: Int) : BaseViewModel() {
    val getData = Pager(PagingConfig(1)) {
        ProjectListPagingSource(cid)
    }.flow.cachedIn(viewModelScope)

    override fun initThat() {

    }

}