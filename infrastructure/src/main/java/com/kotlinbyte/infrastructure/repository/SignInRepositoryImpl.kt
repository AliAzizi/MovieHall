package com.kotlinbyte.infrastructure.repository

import com.kotlinbyte.domain.repository.signin.SignInRepository
import com.kotlinbyte.domain.vobject.AuthResult
import com.kotlinbyte.domain.vobject.Email
import com.kotlinbyte.domain.vobject.Password

class SignInRepositoryImpl : SignInRepository() {
    override suspend fun signIn(email: Email, password: Password): AuthResult {
        TODO("Not yet implemented")
    }

    override suspend fun signIn(token: String): AuthResult {
        TODO("Not yet implemented")
    }
}