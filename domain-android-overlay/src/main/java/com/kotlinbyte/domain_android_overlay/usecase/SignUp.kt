package com.kotlinbyte.domain_android_overlay.usecase

import com.github.kittinunf.result.Result
import com.kotlinbyte.domain.exception.Failure
import com.kotlinbyte.domain.interactor.UseCase
import com.kotlinbyte.domain.repository.signup.SignUpRepository
import com.kotlinbyte.domain.vobject.AuthResult
import com.kotlinbyte.domain.vobject.Email
import com.kotlinbyte.domain.vobject.Password
import com.kotlinbyte.domain.vobject.Username
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class SignUp @Inject constructor(private val repository: SignUpRepository) :
    UseCase<AuthResult, SignUp.Params>() {

    override suspend fun run(params: Params) =
        repository.signUp(params.username, params.email, params.password)

    data class Params(
        val username: Username,
        val email: Email,
        val password: Password
    )
}