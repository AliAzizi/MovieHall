package com.kotlinbyte.domain.repository.usercredentials

import com.kotlinbyte.domain.repository.BaseRepository

abstract class UserCredentialsRepository: BaseRepository() {
    abstract suspend fun read(): String
    abstract suspend fun write(token: String)
}