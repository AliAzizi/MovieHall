package com.kotlinbyte.presentation.features.signin

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.kotlinbyte.domain.vobject.AuthResult
import com.kotlinbyte.domain.vobject.Email
import com.kotlinbyte.domain.vobject.Password
import com.kotlinbyte.domain_android_overlay.platform.ReactiveViewModel
import com.kotlinbyte.domain_android_overlay.usecase.SignInViaEmail
import com.kotlinbyte.domain_android_overlay.usecase.SignInViaGoogle
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInViaGoogleUseCase: SignInViaGoogle,
    private val signInViaEmail: SignInViaEmail
) : ReactiveViewModel<AuthResult>() {

    fun signInViaGoogle(task: Task<GoogleSignInAccount>?) = asyncCallOnViewModelScope {
        signInViaGoogleUseCase.run(task)
    }

    fun signInViaEmail(email: Email, password: Password) = asyncCallOnViewModelScope {
        signInViaEmail.run(SignInViaEmail.Params(email, password))
    }
}