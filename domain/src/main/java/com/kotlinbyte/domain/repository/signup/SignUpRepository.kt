package com.kotlinbyte.domain.repository.signup

import com.kotlinbyte.domain.repository.BaseRepository
import com.kotlinbyte.domain.vobject.AuthResult
import com.kotlinbyte.domain.vobject.Email
import com.kotlinbyte.domain.vobject.Password

interface SignUpRepository: BaseRepository {
    suspend fun signIn(email: Email, password: Password): AuthResult
}