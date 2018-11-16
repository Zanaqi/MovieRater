package com.example.mirza.movieraterbasic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.view_movie.*

class ViewMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_movie)

        val movie = MovieEntity()

        title_value.setText(movie.title)
        desc_value.setText(movie.overview)
        lang_value.setText(movie.language)
        date_value.setText(movie.releaseDate)
        suit_value.setText(movie.suitable)

    }
}