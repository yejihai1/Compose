package com.yjh.main.ui

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yjh.network.model.Article
import com.yjh.network.retrofit.syncLaunchRequest

class MainPagingSource : PagingSource<Int, Article>() {

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val curPageNum = params.key ?: 0
        val result = mutableListOf<Article>()
        (if (curPageNum == 0) syncLaunchRequest { getTopArticle() } else null)?.data?.let {
            result.addAll(it)
        }
        val resp = syncLaunchRequest { getArticleList(curPageNum) }

        result.addAll(resp.data.datas)

        val nextPage = if (curPageNum < resp.data.pageCount) {
            curPageNum + 1
        } else {
            null
        }

        return LoadResult.Page(data = result, prevKey = null, nextKey = nextPage)
    }
}