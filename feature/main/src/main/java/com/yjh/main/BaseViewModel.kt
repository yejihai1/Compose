package com.yjh.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private var _isInit = mutableStateOf(false)

    private val isInit: Boolean
        get() = _isInit.value


    abstract fun start()

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

    fun initThat(block: () -> Unit) {
        if (!isInit) {
            block.invoke()
            requestInitialized()
        }
    }
}