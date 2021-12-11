package com.kotlinbyte.domain_android_overlay.usecase

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.kotlinbyte.domain.interactor.UseCase
import com.kotlinbyte.domain.vobject.AuthResult
import com.kotlinbyte.domain_android_overlay.repository.SignInRepositoryFramework
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class SignInViaGoogle @Inject constructor(private val repository: SignInRepositoryFramework) :
    UseCase<AuthResult, Task<GoogleSignInAccount>?>() {

    override suspend fun run(params: Task<GoogleSignInAccount>?) = repository.signIn(params)
}