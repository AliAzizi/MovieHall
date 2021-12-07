package com.kotlinbyte.infrastructure.datasource.local

import android.content.SharedPreferences
import com.kotlinbyte.domain.exception.AuthenticationRequiredException
import com.kotlinbyte.domain.utils.KeyConstants
import com.kotlinbyte.domain.vobject.AuthResult
import javax.inject.Inject
import javax.inject.Singleton

interface UserCredentialsLocalDataSource {
    suspend fun writeToken(token: String)
    suspend fun getAuth(): AuthResult
    suspend fun isAuthenticated(): Boolean
}

@Singleton
class SPUserCredentialsLocalDataSource @Inject constructor(private val sharedPreferences: SharedPreferences) :
    UserCredentialsLocalDataSource {

    var authResult: AuthResult? = null

    override suspend fun writeToken(token: String) = with(sharedPreferences.edit()) {
        putString(KeyConstants.TOKEN, token)
        apply()
    }


    override suspend fun getAuth() =
        authResult ?: sharedPreferences.getString(KeyConstants.TOKEN, null)?.let {
            authResult = AuthResult(it)
            authResult
        }
        ?: throw AuthenticationRequiredException()


    override suspend fun isAuthenticated(): Boolean = authResult == null
}