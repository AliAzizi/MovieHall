package com.kotlinbyte.presentation.features.signup

import com.kotlinbyte.domain.vobject.AuthResult
import com.kotlinbyte.domain.vobject.Email
import com.kotlinbyte.domain.vobject.Password
import com.kotlinbyte.domain.vobject.Username
import com.kotlinbyte.domain_android_overlay.platform.ReactiveViewModel
import com.kotlinbyte.domain_android_overlay.usecase.SignUp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val signUpUseCase: SignUp) :
    ReactiveViewModel<AuthResult>() {

    fun signUp(username: Username, email: Email, password: Password) = asyncCallOnViewModelScope {
        signUpUseCase.run(SignUp.Params(username, email, password))
    }

}