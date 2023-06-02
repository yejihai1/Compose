package com.yjh.official.ui

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.yjh.ui.base.BaseViewModel

class OfficialListViewModel(private val cid: Int) : BaseViewModel() {
    val getData = Pager(PagingConfig(1)) {
        OfficialListPagingSource(cid)
    }.flow

    override fun initThat() {

    }

}