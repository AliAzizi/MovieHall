package com.kotlinbyte.domain.entity

import com.kotlinbyte.domain.entity.base.Person

data class Director(override val id: String, override val fullName: String): Person()