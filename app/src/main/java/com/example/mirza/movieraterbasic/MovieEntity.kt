package com.example.mirza.movieraterbasic

open class MovieEntity(title: String, overview: String, language: String, releaseDate: String, suitable: String,
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