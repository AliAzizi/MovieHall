package com.kotlinbyte.domain.repository.usercredentials

interface UserCredentialsRepository {
    suspend fun read(): String
    suspend fun write(token: String)
}