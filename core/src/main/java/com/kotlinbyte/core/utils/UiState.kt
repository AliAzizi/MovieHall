package com.kotlinbyte.core.utils

sealed class UiState<out T> {

    object Initial : UiState<Nothing>()

    object Loading : UiState<Nothing>()

    data class Loaded<out T>(val data: T?) : UiState<T>()

    data class Error(val reason: String?) : UiState<Nothing>()
}