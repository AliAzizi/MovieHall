package com.kotlinbyte.core.platform

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.github.kittinunf.result.Result
import com.kotlinbyte.domain.exception.Failure
import com.kotlinbyte.core.utils.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

typealias RememberableCall = () -> Unit

abstract class ReactiveViewModel<D : Any>() : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<D>>(UiState.Initial)

    val uiState: StateFlow<UiState<D>> = _uiState

    var lastCall: RememberableCall? = null

    protected fun asyncCallOnViewModelScope(
        result: suspend () -> Result<D, Failure>
    ) {
        viewModelScope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                result()
            }
            handleResult(deferred.await())
        }
    }

    protected fun handleResult(result: Result<D, Failure>) {
        onLoading()
        result.fold(
            success = {
                onSuccess(it)
            },
            failure = {
                onError(it)
            },
        )
    }

    open fun onSuccess(data: D) {
        _uiState.value = UiState.Loaded(data)
    }

    open fun onError(failure: Failure?) {
        _uiState.value = UiState.Error(null)
    }

    open fun onLoading() {
        _uiState.value = UiState.Loading
    }

    protected fun rememberableCall(rememberableCall: RememberableCall) {
        lastCall = rememberableCall
        rememberableCall()
    }

}

