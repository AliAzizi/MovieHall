package com.kotlinbyte.presentation.features.signin

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.kotlinbyte.domain.vobject.AuthResult
import com.kotlinbyte.domain_android_overlay.platform.ReactiveViewModel
import com.kotlinbyte.domain_android_overlay.usecase.SignInViaGoogle
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class SignInViewModel(private val signInViaGoogleUseCase: SignInViaGoogle) :
    ReactiveViewModel<AuthResult>() {

    fun signInViaGoogle(task: Task<GoogleSignInAccount>?) {
        task?.let {
            asyncCallOnViewModelScope {
                signInViaGoogleUseCase.run(task)
            }
        }
    }
}