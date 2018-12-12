package com.example.mirza.movieraterbasic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_add_movie.*
import kotlinx.android.synthetic.main.add_movie.*

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
        }

        return super.onOptionsItemSelected(item)
    }
}
