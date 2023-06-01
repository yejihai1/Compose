package com.yjh.project.ui

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.yjh.ui.base.BaseViewModel

class ProjectListViewModel(private val cid: Int) : BaseViewModel() {
    val getData = Pager(PagingConfig(1)) {
        ProjectListPagingSource(cid)
    }.flow

    override fun initThat() {

    }

}