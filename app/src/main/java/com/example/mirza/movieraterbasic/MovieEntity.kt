package com.example.mirza.movieraterbasic

class MovieEntity {

    var title: String
    var overview: String
    var language: String
    var releaseDate: String
    var suitable: String
    var violence: Boolean
    var languageUsed: Boolean

    init {
        title = "Venom"
        overview = "OverView"
        language = "English"
        releaseDate = "03-10-2018"
        suitable = "Yes"
        violence = true
        languageUsed = false
    }

}