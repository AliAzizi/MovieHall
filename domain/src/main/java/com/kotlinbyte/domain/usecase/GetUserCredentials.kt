package com.kotlinbyte.domain.usecase

import com.github.kittinunf.result.Result
import com.kotlinbyte.domain.exception.Failure
import com.kotlinbyte.domain.repository.usercredentials.UserCredentialsRepository
import com.kotlinbyte.domain.vobject.AuthResult
import kotlin.coroutines.CoroutineContext

class GetUserCredentials(
    private val repository: UserCredentialsRepository,
    context: CoroutineContext
) : UseCase<AuthResult, UseCase.None>(context) {

    override suspend fun run(params: None): Result<AuthResult, Failure> = repository.read()
}