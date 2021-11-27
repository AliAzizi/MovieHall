package com.kotlinbyte.domain.vobject

data class AuthResult(val token: String) {
    init {
        require(token.isNotEmpty())
    }
}