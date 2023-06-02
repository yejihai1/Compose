package com.yjh.navigation.ui

import com.yjh.network.model.TutorialData
import com.yjh.network.retrofit.launchRequest
import com.yjh.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

class TutorialViewModel : BaseViewModel() {
    private val _tutorialTreeData: MutableStateFlow<MutableList<TutorialData>> =
        MutableStateFlow(
            mutableListOf()
        )

    val tutorialTreeData: StateFlow<MutableList<TutorialData>> =
        _tutorialTreeData.asStateFlow()

    override fun initThat() {
        getTutorialTree()
    }


    private fun getTutorialTree() {
        async {
            launchRequest { getTutorialTree() }.map { it.data }.collect {
                _tutorialTreeData.value = it
            }
        }
    }
}