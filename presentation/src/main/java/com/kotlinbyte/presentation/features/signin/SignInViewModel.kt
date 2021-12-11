package com.kotlinbyte.presentation.features.signin

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.kotlinbyte.domain_android_overlay.platform.ReactiveViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class SignInViewModel : ReactiveViewModel<Nothing>() {

    fun signInViaGoogle(task: Task<GoogleSignInAccount>?) {
        task?.let {

        }
    }
}