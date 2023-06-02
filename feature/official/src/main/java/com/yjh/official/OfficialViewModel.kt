package com.yjh.official

import com.yjh.network.model.Project
import com.yjh.network.retrofit.launchRequest
import com.yjh.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

class OfficialViewModel : BaseViewModel() {
    private val _officialListData: MutableStateFlow<MutableList<Project>> = MutableStateFlow(
        mutableListOf()
    )
    val officialListData: StateFlow<MutableList<Project>> = _officialListData.asStateFlow()

    private fun getProjectTree() {
        async {
            launchRequest {
                getWxArticleTree()
            }.map { it.data }.collect {
                _officialListData.value = it
            }
        }
    }

    override fun initThat() {
        getProjectTree()
    }

}