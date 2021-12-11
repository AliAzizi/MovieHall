package com.kotlinbyte.domain_android_overlay.navigation.result

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import javax.inject.Inject

class GoogleSignInResultContract @Inject constructor() :
    ActivityResultContract<Int, Task<GoogleSignInAccount>?>() {


    override fun createIntent(context: Context, input: Int?): Intent {
        val gso = with(GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)) {
            requestIdToken("")
            requestEmail()
            build()
        }

        return GoogleSignIn.getClient(context, gso).signInIntent
    }

    override fun parseResult(resultCode: Int, intent: Intent?) = when (resultCode) {
        Activity.RESULT_OK -> {
            GoogleSignIn.getSignedInAccountFromIntent(intent)
        }
        else -> null
    }

}