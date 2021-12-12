package com.kotlinbyte.domain.repository.signin

import com.github.kittinunf.result.Result
import com.kotlinbyte.domain.exception.Failure
import com.kotlinbyte.domain.repository.BaseRepository
import com.kotlinbyte.domain.vobject.AuthResult
import com.kotlinbyte.domain.vobject.Email
import com.kotlinbyte.domain.vobject.Password

abstract class SignInRepository : BaseRepository() {
    abstract suspend fun signIn(email: Email, password: Password): Result<AuthResult, Failure>
    abstract suspend fun signIn(token: String): Result<AuthResult, Failure>
}