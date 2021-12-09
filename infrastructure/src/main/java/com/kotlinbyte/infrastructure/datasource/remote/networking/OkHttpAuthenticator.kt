package com.kotlinbyte.infrastructure.datasource.remote.networking

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route


class OkHttpAuthenticator : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        TODO("Not yet implemented")
    }

}