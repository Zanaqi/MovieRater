package com.example.mirza.movieraterbasic

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_view_movie_details.*

class ViewMovieDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_movie_details)

        registerForContextMenu(review)

        val movie = MovieEntity()

        title_value.setText(movie.title)
        desc_value.setText(movie.overview)
        lang_value.setText(movie.language)
        date_value.setText(movie.releaseDate)


    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {

        super.onCreateContextMenu(menu, v, menuInfo)

        if (v?.id == R.id.review) {
            menu?.add(1,1001,1,"Add Review")
        }

    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == 1001) {
            val rateMovieIntent = Intent(this, RateMovie::class.java)
            startActivity(rateMovieIntent)
        }

        return super.onContextItemSelected(item)

    }

}