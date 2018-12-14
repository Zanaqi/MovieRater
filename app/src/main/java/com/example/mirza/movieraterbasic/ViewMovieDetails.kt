package com.example.mirza.movieraterbasic

import android.app.Activity
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

        registerForContextMenu(review_text)

        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")
        val lang = intent.getStringExtra("lang")
        val date = intent.getStringExtra("date")
        val suitable = intent.getStringExtra("suitable")
        val violence = intent.getBooleanExtra("violence", false)
        val langaugeUsed = intent.getBooleanExtra("languageUsed", false)

        title_value.setText(title)
        desc_value.setText(desc)
        lang_value.setText(lang)
        date_value.setText(date)
        suit_value.setText(suitable)
        violence_value.setText(violence.toString())
        langUsed_value.setText(langaugeUsed.toString())

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {

        super.onCreateContextMenu(menu, v, menuInfo)

        if (v?.id == R.id.review_text) {
            menu?.add(1,1001,1,"Add Review")
        }

    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == 1001) {
            val rateMovieIntent = Intent(this, RateMovie::class.java)
            startActivityForResult(rateMovieIntent, 1)
        }

        return super.onContextItemSelected(item)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val rating = data!!.getFloatExtra("rating", 1.2f)
                val review = data.getStringExtra("review")

                ratingStars.rating = rating
                ratingStars.visibility = View.VISIBLE
                review_text.setText(review)
            }
        }
    }

}