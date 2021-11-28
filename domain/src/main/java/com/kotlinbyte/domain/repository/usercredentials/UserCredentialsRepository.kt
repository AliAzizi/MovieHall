package com.kotlinbyte.domain.repository.usercredentials

import com.github.kittinunf.result.Result
import com.kotlinbyte.domain.exception.Failure
import com.kotlinbyte.domain.repository.BaseRepository
import com.kotlinbyte.domain.vobject.AuthResult

abstract class UserCredentialsRepository : BaseRepository() {
    abstract suspend fun read(): Result<AuthResult, Failure>
    abstract suspend fun write(token: String): Result<Nothing, Failure>
}