package com.kotlinbyte.domain.repository.signup

import com.kotlinbyte.domain.repository.BaseRepository
import com.kotlinbyte.domain.vobject.AuthResult
import com.kotlinbyte.domain.vobject.Email
import com.kotlinbyte.domain.vobject.Password

abstract class SignUpRepository: BaseRepository() {
    abstract suspend fun signIn(email: Email, password: Password): AuthResult
}