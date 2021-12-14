package com.kotlinbyte.domain.entity

import com.kotlinbyte.domain.entity.base.Title

data class Playlist(
    val id: String,
    val name: String,
    val listOfTitle: List<Title>
)