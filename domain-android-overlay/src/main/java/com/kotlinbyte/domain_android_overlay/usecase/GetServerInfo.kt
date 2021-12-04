package com.kotlinbyte.domain_android_overlay.usecase

import com.github.kittinunf.result.Result
import com.kotlinbyte.domain.entity.ServerInfo
import com.kotlinbyte.domain.exception.Failure
import com.kotlinbyte.domain.interactor.UseCase
import com.kotlinbyte.domain.repository.ServerInfoRepository
import com.kotlinbyte.domain.repository.usercredentials.UserCredentialsRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@ViewModelScoped
class GetServerInfo @Inject constructor(
    private val repository: ServerInfoRepository,
    context: CoroutineContext
) : UseCase<ServerInfo, UseCase.None>(context) {

    override suspend fun run(params: None): Result<ServerInfo, Failure> = repository.getInfo()
}