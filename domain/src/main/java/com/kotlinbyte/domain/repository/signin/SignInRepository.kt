package com.kotlinbyte.domain.repository.signin

import com.kotlinbyte.domain.repository.BaseRepository
import com.kotlinbyte.domain.vobject.AuthResult
import com.kotlinbyte.domain.vobject.Email
import com.kotlinbyte.domain.vobject.Password
import com.kotlinbyte.domain.vobject.Username

abstract class SignInRepository : BaseRepository() {
    abstract suspend fun signIn(email: Email, password: Password): AuthResult
    abstract suspend fun signIn(token: String): AuthResult
}