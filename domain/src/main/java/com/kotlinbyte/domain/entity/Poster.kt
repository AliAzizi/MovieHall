package com.kotlinbyte.domain.entity

import java.awt.Image

data class Poster(
    val image: Image,
    val aspectRatio: Float?,
    val language: Language?,
    val width: Double?,
    val height: Double?
)