package com.kotlinbyte.infrastructure.datasource.remote.networking

import com.kotlinbyte.infrastructure.datasource.local.UserCredentialsLocalDataSource
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request

fun Request.authenticationRequired(): Boolean = EndPoints.authenticationRequired(
    url().encodedPath()
)


fun Request.withAuthorization(token: String): Request = with(newBuilder()) {
    addHeader(HttpHeaders.AUTHORIZATION, token)
    build()
}


fun Interceptor.Chain.authenticationAwareRequest(uc: UserCredentialsLocalDataSource): Request =
    if (request().authenticationRequired()) {
        request().withAuthorization(
            runBlocking {
                uc.getAuth().token
            }
        )

    } else request()
