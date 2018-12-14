package com.example.mirza.movieraterbasic

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_add_movie.*

class AddMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)

        suitChk1.setOnClickListener{

            if (suitChk1.isChecked) {
                suitChk2.setVisibility(View.VISIBLE)
                suitChk3.setVisibility(View.VISIBLE)

            } else {
                suitChk2.setVisibility(View.GONE)
                suitChk3.setVisibility(View.GONE)
            }
        }

        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_movie, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == R.id.miClear) {

            movie_title.text.clear()
            description.text.clear()
            rBtnEng.isChecked = true
            releaseDate.text.clear()
            suitChk1.isChecked = false
            suitChk2.isChecked = false
            suitChk3.isChecked = false

            suitChk2.setVisibility(View.GONE)
            suitChk3.setVisibility(View.GONE)

        }
        else if (item?.itemId == R.id.miAdd) {

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
