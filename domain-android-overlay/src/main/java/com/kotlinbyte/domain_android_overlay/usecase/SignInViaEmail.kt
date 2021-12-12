package com.kotlinbyte.domain_android_overlay.usecase

import com.kotlinbyte.domain.interactor.UseCase
import com.kotlinbyte.domain.repository.signin.SignInRepository
import com.kotlinbyte.domain.vobject.AuthResult
import com.kotlinbyte.domain.vobject.Email
import com.kotlinbyte.domain.vobject.Password
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class SignInViaEmail @Inject constructor(private val repository: SignInRepository) :
    UseCase<AuthResult, SignInViaEmail.Params>() {

    override suspend fun run(params: Params) = repository.signIn(params.email, params.password)

    data class Params(val email: Email, val password: Password)
}