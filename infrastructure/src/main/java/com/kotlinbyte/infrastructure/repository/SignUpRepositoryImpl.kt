package com.kotlinbyte.infrastructure.repository

import com.github.kittinunf.result.Result
import com.kotlinbyte.domain.exception.Failure
import com.kotlinbyte.domain.repository.signup.SignUpRepository
import com.kotlinbyte.domain.vobject.Email
import com.kotlinbyte.domain.vobject.Password
import com.kotlinbyte.domain.vobject.Username
import com.kotlinbyte.infrastructure.datasource.remote.SignUpRemoteDatasource
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    private val remoteDatasource: SignUpRemoteDatasource
) : SignUpRepository() {

    override suspend fun signUp(
        username: Username,
        email: Email,
        password: Password
    ) = try {
        Result.success(remoteDatasource.signUp(username, email, password))
    } catch (ex: Exception) {
        Result.failure(Failure.Unexpected)
    }

}