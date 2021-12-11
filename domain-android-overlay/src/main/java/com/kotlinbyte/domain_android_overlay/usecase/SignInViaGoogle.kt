package com.kotlinbyte.domain_android_overlay.usecase

import com.github.kittinunf.result.Result
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.kotlinbyte.domain.exception.Failure
import com.kotlinbyte.domain.interactor.UseCase

class SignInViaGoogle : UseCase<Nothing, GoogleSignInAccount>() {
    override suspend fun run(params: GoogleSignInAccount): Result<Nothing, Failure> {
        TODO("Not yet implemented")
    }
}