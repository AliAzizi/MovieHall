package com.kotlinbyte.presentation.features.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.kotlinbyte.domain_android_overlay.platform.BaseFragment
import com.kotlinbyte.domain_android_overlay.platform.BaseViewBindingFragment
import com.kotlinbyte.domain_android_overlay.utils.UiState
import com.kotlinbyte.presentation.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment :
    BaseViewBindingFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {

                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun <TYPE> handleUiState(uiState: UiState<TYPE>) {
        when (uiState) {
            is UiState.Initial -> {

            }
            is UiState.Loading -> {

            }
            is UiState.Loaded -> {

            }
            is UiState.Error -> {

            }
        }
    }
}