package com.yjh.navigation.ui

import com.yjh.network.model.NavigationData
import com.yjh.network.model.SystemData
import com.yjh.network.retrofit.launchRequest
import com.yjh.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

class SystemViewModel : BaseViewModel() {
    private val _systemTreeData: MutableStateFlow<MutableList<SystemData>> =
        MutableStateFlow(
            mutableListOf()
        )

    val systemTreeData: StateFlow<MutableList<SystemData>> =
        _systemTreeData.asStateFlow()

    override fun initThat() {
        getSystemTree()
    }


    private fun getSystemTree() {
        async {
            launchRequest { getSystemTree() }.map { it.data }.collect {
                _systemTreeData.value = it
            }
        }
    }
}