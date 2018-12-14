package com.example.mirza.movieraterbasic

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
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

        if (movie.suitable == "Yes") {

            suitChk1.isChecked = true

            suitChk2.setVisibility(View.VISIBLE)
            suitChk3.setVisibility(View.VISIBLE)

            if (movie.violence) {
                suitChk2.isChecked = true
            }

            if (movie.languageUsed) {
                suitChk3.isChecked = true
            }
        }

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.edit_movie_details, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == R.id.miSave) {

            val valid = formValidate()

            if (valid) {
                val viewMovieIntent = Intent(this, ViewMovieDetails::class.java)

                val languageId = findViewById<RadioButton>(language.checkedRadioButtonId)

                val title = movie_title.text.toString()
                val desc = description.text.toString()
                val lang = languageId.text
                val date = releaseDate.text.toString()
                var suitable: String

                if (suitChk1.isChecked) {
                    suitable = "No "
                    if (suitChk2.isChecked) {
                        suitable += "{Violence} "
                    }
                    if (suitChk3.isChecked) {
                        suitable += "{Language Used} "
                    }
                } else {
                    suitable = "Yes"
                }

                viewMovieIntent.putExtra("title", title)
                viewMovieIntent.putExtra("desc", desc)
                viewMovieIntent.putExtra("lang", lang)
                viewMovieIntent.putExtra("date", date)
                viewMovieIntent.putExtra("suitable", suitable)

                startActivity(viewMovieIntent)
            }

        }
        else if (item?.itemId == R.id.miCancel) {
            NavUtils.navigateUpFromSameTask(this)
        }

        return super.onOptionsItemSelected(item)
    }

    fun formValidate(): Boolean {

        var validation = true

        if (movie_title.text.isEmpty()) {

            movie_title.setError("Field Empty")
            validation = false

        }

        if (description.text.isEmpty()) {

            description.setError("Field Empty")
            validation = false

        }

        if (releaseDate.text.isEmpty()) {

            releaseDate.setError("Field Empty")
            validation = false

        }

        return validation

    }
}
