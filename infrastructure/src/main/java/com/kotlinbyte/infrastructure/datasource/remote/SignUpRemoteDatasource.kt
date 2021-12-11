package com.kotlinbyte.infrastructure.datasource.remote

import com.kotlinbyte.domain.vobject.AuthResult
import com.kotlinbyte.domain.vobject.Email
import com.kotlinbyte.domain.vobject.Password
import com.kotlinbyte.domain.vobject.Username

abstract class SignUpRemoteDatasource {
    abstract suspend fun signUp(username: Username, email: Email, password: Password) : AuthResult
}

class SignUpRemoteDatasourceImpl : SignUpRemoteDatasource() {

    override suspend fun signUp(username: Username, email: Email, password: Password): AuthResult {
        TODO("Not yet implemented")
    }

}