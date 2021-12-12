package com.kotlinbyte.domain_android_overlay.repository

import com.github.kittinunf.result.Result
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.kotlinbyte.domain.exception.Failure
import com.kotlinbyte.domain.repository.signin.SignInRepository
import com.kotlinbyte.domain.vobject.AuthResult

abstract class SignInRepositoryFramework : SignInRepository() {
    abstract suspend fun signIn(task: Task<GoogleSignInAccount>?): Result<AuthResult, Failure>
}