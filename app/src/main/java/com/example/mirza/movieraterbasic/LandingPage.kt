package com.example.mirza.movieraterbasic

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_landing_page.*

class LandingPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        val moviesList = applicationContext as Movie

        val mAdapter = MovieAdapter(this, moviesList.get())
        movies_list.adapter = mAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.landing_page, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == R.id.miAddLanding) {

            val addMovieIntent = Intent(this, AddMovie::class.java)
            startActivityForResult(addMovieIntent, 2)

        }

        return super.onOptionsItemSelected(item)
    }
}
