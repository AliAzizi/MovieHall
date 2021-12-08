package com.kotlinbyte.domain_android_overlay.networking

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class OkHttpInterceptor @Inject constructor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("Not yet implemented")
    }

}