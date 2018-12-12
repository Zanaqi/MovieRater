package com.example.mirza.movieraterbasic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import kotlinx.android.synthetic.main.activity_edit_movie.*

class EditMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_movie)

        suitChk1.setOnClickListener{

            if (suitChk1.isChecked) {
                suitChk2.setVisibility(View.VISIBLE)
                suitChk3.setVisibility(View.VISIBLE)

            } else {
                suitChk2.setVisibility(View.GONE)
                suitChk3.setVisibility(View.GONE)
            }
        }

        val movie = MovieEntity()

        movie_title.setText(movie.title)
        description.setText(movie.overview)
        releaseDate.setText(movie.releaseDate)

        when (movie.language) {
            rBtnEng.text -> rBtnEng.isChecked = true
            rBtnChi.text -> rBtnChi.isChecked = true
            rBtnMal.text -> rBtnMal.isChecked = true
            rBtnTam.text -> rBtnTam.isChecked = true
        }

        if (!movie.suitable) {

            suitChk1.isChecked = true

            if (movie.violence) {
                suitChk2.isChecked = true
            }

            if (movie.languageUsed) {
                suitChk3.isChecked = true
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.edit_movie_details, menu)

        return super.onCreateOptionsMenu(menu)
    }
}
