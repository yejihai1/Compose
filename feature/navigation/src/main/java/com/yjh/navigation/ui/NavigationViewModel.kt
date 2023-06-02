package com.yjh.navigation.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import com.yjh.network.model.NavigationData
import com.yjh.network.retrofit.launchRequest
import com.yjh.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

class NavigationViewModel : BaseViewModel() {
    private val _navigationTreeData: MutableStateFlow<MutableList<NavigationData>> =
        MutableStateFlow(
            mutableListOf()
        )

    val navigationTreeData: StateFlow<MutableList<NavigationData>> =
        _navigationTreeData.asStateFlow()

    override fun initThat() {
        getNavigationTree()
    }


    private fun getNavigationTree() {
        async {
            launchRequest { getNavigationTree() }.map { it.data }.collect {
                _navigationTreeData.value = it
            }
        }
    }
}