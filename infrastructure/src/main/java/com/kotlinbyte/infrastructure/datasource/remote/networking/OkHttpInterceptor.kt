package com.kotlinbyte.infrastructure.datasource.remote.networking

import com.kotlinbyte.domain.repository.usercredentials.UserCredentialsRepository
import com.kotlinbyte.infrastructure.datasource.local.UserCredentialsLocalDataSource
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class OkHttpInterceptor @Inject constructor(
    private val userCredentials: UserCredentialsLocalDataSource
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.proceed(
        chain.authenticationAwareRequest(userCredentials)
    )


}