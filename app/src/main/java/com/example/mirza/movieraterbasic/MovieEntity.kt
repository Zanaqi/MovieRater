package com.example.mirza.movieraterbasic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.view_movie.*
import android.content.Intent


class MovieEntity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_movie)

        title_value.setText(intent.getStringExtra("title"))
        desc_value.setText(intent.getStringExtra("overview"))
        lang_value.setText(intent.getStringExtra("language"))
        date_value.setText(intent.getStringExtra("releaseDate"))
        suit_value.setText(intent.getStringExtra("suitability"))

    }
}