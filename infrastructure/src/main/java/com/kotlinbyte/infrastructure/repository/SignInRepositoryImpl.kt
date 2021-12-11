package com.kotlinbyte.infrastructure.repository

import com.github.kittinunf.result.Result
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.kotlinbyte.domain.exception.Failure
import com.kotlinbyte.domain.vobject.AuthResult
import com.kotlinbyte.domain.vobject.Email
import com.kotlinbyte.domain.vobject.Password
import com.kotlinbyte.domain_android_overlay.repository.SignInRepositoryFramework
import com.kotlinbyte.infrastructure.datasource.remote.SignInRemoteDatasource
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(private val remote: SignInRemoteDatasource) :
    SignInRepositoryFramework() {


    override suspend fun signIn(email: Email, password: Password): Result<AuthResult, Failure> {
        TODO("Not yet implemented")
    }

    override suspend fun signIn(token: String): Result<AuthResult, Failure> {
        TODO("Not yet implemented")
    }


    override suspend fun signIn(googleSignInAccount: GoogleSignInAccount) = try {
        Result.success(remote.signIn(googleSignInAccount))
    } catch (ex: Exception) {
        Result.failure(Failure.AuthenticationFailed)
    }

}