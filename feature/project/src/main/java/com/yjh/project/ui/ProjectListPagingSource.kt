package com.yjh.project.ui

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yjh.network.model.ProjectItemData
import com.yjh.network.retrofit.syncLaunchRequest

class ProjectListPagingSource(private val cid: Int) : PagingSource<Int, ProjectItemData>() {
    override fun getRefreshKey(state: PagingState<Int, ProjectItemData>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProjectItemData> {
        val curPageNum = params.key ?: 0
        val result = mutableListOf<ProjectItemData>()
        val resp = syncLaunchRequest { getProjectList(curPageNum, cid) }
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