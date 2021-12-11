package com.kotlinbyte.domain_android_overlay.repository

import com.github.kittinunf.result.Result
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.kotlinbyte.domain.exception.Failure
import com.kotlinbyte.domain.repository.BaseRepository
import com.kotlinbyte.domain.repository.signin.SignInRepository
import com.kotlinbyte.domain.vobject.AuthResult
import com.kotlinbyte.domain.vobject.Email
import com.kotlinbyte.domain.vobject.Password
import com.kotlinbyte.domain.vobject.Username

abstract class SignInRepositoryFramework : SignInRepository() {
    abstract suspend fun signIn(googleSignInAccount: GoogleSignInAccount): Result<AuthResult, Failure>
}