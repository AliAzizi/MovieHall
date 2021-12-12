package com.kotlinbyte.domain.entity

import com.kotlinbyte.domain.entity.base.Person

data class Writer(override val id: String, override val fullName: String): Person()