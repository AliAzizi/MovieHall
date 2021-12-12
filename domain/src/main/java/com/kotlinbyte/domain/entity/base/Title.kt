package com.kotlinbyte.domain.entity.base

import com.kotlinbyte.domain.entity.*
import com.kotlinbyte.domain.entity.Image
import com.kotlinbyte.domain.entity.Plot
import com.kotlinbyte.domain.entity.Video
import java.time.Year
import java.util.*

interface Title {
    val id: String
    val title: String
    val originalTitle: String?
    val fullTitle: String
    val type: Type
    val year: Year
    val image: Image
    val releaseDate: Date
    val plot: Plot
    val awards: String?
    val directorList: List<Director>?
    val writerList: List<Writer>?
    val starList: List<Person>?
    val actorList: List<Actor>?
    val genreList: List<Genre>?
    val companyList: List<Company>?
    val countryList: List<Country>?
    val languageList: List<Language>?
    val ratings: List<Rating>?
    val posters: List<Poster>?
    val images: List<Image>?
    val trailers: List<Video>?
    val keywords: List<String>?
    val similars: List<Title>

    enum class Type {
        Movie,
        TVSeries
    }
}