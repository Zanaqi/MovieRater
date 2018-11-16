package com.example.mirza.movieraterbasic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.rate_movie.*


class RateMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rate_movie)

        val movie = MovieEntity()

        rateMovieText.setText(movie.title)
    }
}