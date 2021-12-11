package com.kotlinbyte.presentation.features.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.kotlinbyte.domain_android_overlay.platform.BaseFragment
import com.kotlinbyte.domain_android_overlay.platform.BaseViewBindingFragment
import com.kotlinbyte.presentation.databinding.FragmentSignupBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment :
    BaseViewBindingFragment<FragmentSignupBinding>(FragmentSignupBinding::inflate) {

    private val viewModel: SignUpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}