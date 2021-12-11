package com.kotlinbyte.domain.repository.signup

import com.github.kittinunf.result.Result
import com.kotlinbyte.domain.exception.Failure
import com.kotlinbyte.domain.repository.BaseRepository
import com.kotlinbyte.domain.vobject.AuthResult
import com.kotlinbyte.domain.vobject.Email
import com.kotlinbyte.domain.vobject.Password
import com.kotlinbyte.domain.vobject.Username

abstract class SignUpRepository : BaseRepository() {
    abstract suspend fun signUp(
        username: Username,
        email: Email,
        password: Password
    ): Result<AuthResult, Failure>
}