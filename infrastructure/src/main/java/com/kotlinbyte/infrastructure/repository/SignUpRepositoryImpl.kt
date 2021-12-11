package com.kotlinbyte.infrastructure.repository

import com.github.kittinunf.result.Result
import com.kotlinbyte.domain.exception.Failure
import com.kotlinbyte.domain.repository.signup.SignUpRepository
import com.kotlinbyte.domain.vobject.AuthResult
import com.kotlinbyte.domain.vobject.Email
import com.kotlinbyte.domain.vobject.Password

class SignUpRepositoryImpl : SignUpRepository() {
    override suspend fun signIn(email: Email, password: Password): Result<AuthResult, Failure> {
        TODO("Not yet implemented")
    }
}