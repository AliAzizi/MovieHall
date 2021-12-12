package com.kotlinbyte.domain_android_overlay.usecase

import com.github.kittinunf.result.Result
import com.kotlinbyte.domain.exception.Failure
import com.kotlinbyte.domain.interactor.UseCase
import com.kotlinbyte.domain.repository.usercredentials.UserCredentialsRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


@ViewModelScoped
class GetUserAuthenticationStatus @Inject constructor(
    private val repository: UserCredentialsRepository,
    context: CoroutineContext
) : UseCase<Boolean, UseCase.None>(context) {

    override suspend fun run(params: None): Result<Boolean, Failure> = repository.isAuthenticated()
}