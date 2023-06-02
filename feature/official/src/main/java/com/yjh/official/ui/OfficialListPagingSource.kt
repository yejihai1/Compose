package com.yjh.official.ui

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yjh.network.model.Article
import com.yjh.network.retrofit.syncLaunchRequest

class OfficialListPagingSource(private val cid: Int) : PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val curPageNum = params.key ?: 0
        val result = mutableListOf<Article>()
        val resp = syncLaunchRequest { getWxArticleList(curPageNum, cid) }

        resp?.data?.datas?.let {
            result.addAll(it)
        }


        val nextPage = if (curPageNum < (resp?.data?.pageCount ?: 0)) {
            curPageNum + 1
        } else {
            null
        }

        return LoadResult.Page(data = result, prevKey = null, nextKey = nextPage)
    }

}