package com.yjh.project

import com.yjh.network.model.ProjectData
import com.yjh.network.retrofit.launchRequest
import com.yjh.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

class ProjectViewModel : BaseViewModel() {
    private val _projectListData: MutableStateFlow<MutableList<ProjectData>> = MutableStateFlow(
        mutableListOf()
    )
    val projectListData: StateFlow<MutableList<ProjectData>> = _projectListData.asStateFlow()

    private fun getProjectTree() {
        async {
            launchRequest {
                getProjectTree()
            }.map { it.data }.collect {
                _projectListData.value = it
            }
        }
    }

    override fun initThat() {
        getProjectTree()
    }

}