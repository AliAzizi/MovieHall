package com.kotlinbyte.domain.entity

import com.kotlinbyte.domain.entity.base.Cast

data class Actor(
    override val image: Image,
    override val id: String,
    override val fullName: String,
    val asCharacter: String
) : Cast()
