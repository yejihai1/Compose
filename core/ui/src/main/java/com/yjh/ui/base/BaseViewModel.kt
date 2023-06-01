package com.yjh.ui.base

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private var _isInit = mutableStateOf(false)

    private val isInit: Boolean
        get() = _isInit.value


    fun start() {
        if (!isInit) {
            initThat()
            requestInitialized()
        }
    }

    private fun requestInitialized() {
        _isInit.value = true
    }

    fun resetInitState() {
        _isInit.value = false
    }

    fun async(block: suspend () -> Unit) {
        viewModelScope.launch {
            block.invoke()
        }
    }

    abstract fun initThat()
}