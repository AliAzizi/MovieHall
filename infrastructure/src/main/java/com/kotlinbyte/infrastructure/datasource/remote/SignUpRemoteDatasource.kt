package com.kotlinbyte.infrastructure.datasource.remote

import com.kotlinbyte.domain.vobject.AuthResult

abstract class SignUpRemoteDatasource {
    abstract suspend fun signIn() : AuthResult
}

class SignUpRemoteDatasourceImpl : SignUpRemoteDatasource() {

    override suspend fun signIn(): AuthResult {
        TODO("Not yet implemented")
    }

}