package com.kotlinbyte.domain.entity.base

import com.kotlinbyte.domain.entity.*
import com.kotlinbyte.domain.entity.Image
import com.kotlinbyte.domain.entity.Plot
import com.kotlinbyte.domain.entity.Video
import java.time.Year
import java.util.*

abstract class Title {
    abstract val id: String
    abstract val title: String
    abstract val originalTitle: String?
    abstract val fullTitle: String
    abstract val type: Type
    abstract val year: Year
    abstract val image: Image
    abstract val releaseDate: Date
    abstract val plot: Plot
    abstract val awards: String?
    abstract val directorList: List<Director>?
    abstract val writerList: List<Writer>?
    abstract val starList: List<Person>?
    abstract val actorList: List<Actor>?
    abstract val genreList: List<Genre>?
    abstract val companyList: List<Company>?
    abstract val countryList: List<Country>?
    abstract val languageList: List<Language>?
    abstract val ratings: List<Rating>?
    abstract val posters: List<Poster>?
    abstract val images: List<Image>?
    abstract val trailers: List<Video>?
    abstract val keywords: List<String>?
    abstract val similars: List<Title>

    enum class Type {
        Movie,
        TVSeries
    }
}