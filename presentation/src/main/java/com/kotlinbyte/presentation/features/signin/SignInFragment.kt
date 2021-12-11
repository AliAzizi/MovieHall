package com.kotlinbyte.presentation.features.signin

import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import androidx.fragment.app.viewModels
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.kotlinbyte.domain_android_overlay.navigation.result.GoogleSignInResultContract
import com.kotlinbyte.domain_android_overlay.platform.BaseFragment
import com.kotlinbyte.domain_android_overlay.platform.BaseViewBindingFragment
import com.kotlinbyte.presentation.databinding.FragmentSigninBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment :
    BaseViewBindingFragment<FragmentSigninBinding>(FragmentSigninBinding::inflate) {

    private val viewModel: SignInViewModel by viewModels()

    @Inject
    lateinit var registry: ActivityResultRegistry

    @Inject
    lateinit var googleAuthSignInResultContract: ActivityResultContract<Int, Task<GoogleSignInAccount>?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerForActivityResult(
            googleAuthSignInResultContract,
            registry,
            viewModel::signInViaGoogle
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun onSignInButtonClicked(){

    }
}