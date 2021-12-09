package com.kotlinbyte.infrastructure.datasource.remote.networking

object EndPoints {
    const val BASE_URL = "https://www.moviehall.com/"

    const val applicationConfiguration = "app/configuration"

    val authRequiredEndpointsList: List<String> = listOf(applicationConfiguration)


    fun authenticationRequired(url: String) = authRequiredEndpointsList.contains("/$url")
}