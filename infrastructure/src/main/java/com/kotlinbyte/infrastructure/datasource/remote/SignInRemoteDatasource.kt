package com.kotlinbyte.infrastructure.datasource.remote

import com.kotlinbyte.domain.vobject.AuthResult

abstract class SignInRemoteDatasource {
    abstract suspend fun signIn(): AuthResult
}

class SignInRemoteDatasourceImpl : SignInRemoteDatasource() {

    override suspend fun signIn(): AuthResult {
        TODO("Not yet implemented")
    }

}