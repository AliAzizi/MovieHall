package com.kotlinbyte.domain.entity

import java.time.Year

data class Season(
    val id: String,
    val title: String,
    val fullTitle: String?,
    val year: Year?,
    val episodes: List<Episode>
)