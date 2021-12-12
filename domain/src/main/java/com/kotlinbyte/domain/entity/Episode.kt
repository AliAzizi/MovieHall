package com.kotlinbyte.domain.entity

data class Episode(
    val id: String,
    val title: String,
    val image: Image?,
    val plot: Plot?,
    val rating: Rating
)