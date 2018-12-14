package com.example.mirza.movieraterbasic

import android.app.Application

class MovieEntity(title: String, overview: String, language: String, releaseDate: String, suitable: String,
                  violence: Boolean, languageUsed: Boolean, mImageDrawable: Int) {

    var title: String
    var overview: String
    var language: String
    var releaseDate: String
    var suitable: String
    var violence: Boolean
    var languageUsed: Boolean
    var mImageDrawable: Int

    init {

        this.title = title
        this.overview = overview
        this.language = language
        this.releaseDate = releaseDate
        this.suitable = suitable
        this.violence = violence
        this.languageUsed = languageUsed
        this.mImageDrawable = mImageDrawable

    }

}

class Movie: Application() {

    var movieArr: ArrayList<MovieEntity>
    var singleton: Movie? = null

    init {
        this.movieArr = arrayListOf()
    }

    fun add(movie: MovieEntity) {
        this.movieArr.add(movie)
    }

    fun get(): ArrayList<MovieEntity> {
        return this.movieArr
    }

    fun getInstance(): Movie? {
        return singleton
    }

    override fun onCreate() {
        super.onCreate()
        singleton = this
    }

}