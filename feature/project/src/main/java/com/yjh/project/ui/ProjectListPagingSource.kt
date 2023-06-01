package com.yjh.project.ui

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yjh.network.model.ProjectItem
import com.yjh.network.retrofit.syncLaunchRequest

class ProjectListPagingSource(private val cid: Int) : PagingSource<Int, ProjectItem>() {
    override fun getRefreshKey(state: PagingState<Int, ProjectItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProjectItem> {
        val curPageNum = params.key ?: 0
        val result = mutableListOf<ProjectItem>()
        val resp = syncLaunchRequest { getProjectList(curPageNum, cid) }

        result.addAll(resp.data.datas)

        val nextPage = if (curPageNum < resp.data.pageCount) {
            curPageNum + 1
        } else {
            null
        }

        return LoadResult.Page(data = result, prevKey = null, nextKey = nextPage)
    }

}