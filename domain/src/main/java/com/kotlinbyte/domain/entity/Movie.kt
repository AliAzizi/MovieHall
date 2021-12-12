package com.kotlinbyte.domain.entity

import com.kotlinbyte.domain.entity.base.Person
import com.kotlinbyte.domain.entity.base.Title
import java.time.Duration
import java.time.Year
import java.util.*

data class Movie(
    override val id: String,
    override val title: String,
    override val originalTitle: String?,
    override val fullTitle: String,
    override val type: Type = Type.Movie,
    override val year: Year,
    override val image: Image,
    override val releaseDate: Date,
    override val plot: Plot,
    override val awards: String?,
    override val directorList: List<Director>?,
    override val writerList: List<Writer>?,
    override val starList: List<Person>?,
    override val actorList: List<Actor>?,
    override val genreList: List<Genre>?,
    override val companyList: List<Company>?,
    override val countryList: List<Country>?,
    override val languageList: List<Language>?,
    override val ratings: List<Rating>?,
    override val posters: List<Poster>?,
    override val images: List<Image>?,
    override val trailers: List<Video>?,
    override val keywords: List<String>?,
    override val similars: List<Title>,
    val runtimeMinutes: Duration,
    val runtimeMinutesStr: String
): Title()