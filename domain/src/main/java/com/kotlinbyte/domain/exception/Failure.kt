package com.kotlinbyte.domain.exception

sealed class Failure : Throwable() {
    object NetworkConnection : Failure()

    object ResponseContainsError : Failure()

    object AuthenticationRequired : Failure()

    object Unexpected : Failure()

    object GoogleApi : Failure()

    abstract class CustomFailure : Failure()

}