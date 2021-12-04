package com.kotlinbyte.presentation.features.splash

import androidx.lifecycle.viewModelScope
import com.kotlinbyte.domain.entity.ServerInfo
import com.kotlinbyte.domain.interactor.UseCase
import com.kotlinbyte.domain_android_overlay.platform.ReactiveViewModel
import com.kotlinbyte.domain_android_overlay.usecase.GetServerInfo
import com.kotlinbyte.domain_android_overlay.usecase.GetUserAuthenticationStatus
import com.kotlinbyte.domain_android_overlay.usecase.GetUserCredentials
import kotlinx.coroutines.launch

class SplashViewModel(
    private val getUserAuthenticationStatus: GetUserAuthenticationStatus,
    private val getServerInfo: GetServerInfo
) : ReactiveViewModel<ServerInfo>() {

    fun fetchInfo() {
        asyncCallOnViewModelScope {
            getServerInfo.run(UseCase.None())
        }
    }

    fun isUserAuthenticated(status: (Boolean) -> Unit) {
        getUserAuthenticationStatus(UseCase.None(), viewModelScope) {
            it.fold(
                status,
                ::onError
            )
        }
    }


}