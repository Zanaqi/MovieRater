package com.example.mirza.movieraterbasic

class MovieEntity {

    var title: String
    var overview: String
    var language: String
    var releaseDate: String
    var suitable: Boolean
    var violence: Boolean
    var languageUsed: Boolean

    init {
        title = "Venom"
        overview = "OverView"
        language = "English"
        releaseDate = "03-10-2018"
        suitable = true
        violence = true
        languageUsed = false
    }

}