package com.example.mirza.movieraterbasic

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_landing_page.*

class LandingPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)
        registerForContextMenu(landingPageText)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if (v?.id == R.id.landingPageText) {
            menu?.add(1,1001,1,"Add")
            menu?.add(1,1002,2,"Edit")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == 1001) {
            val addMovieIntent = Intent(this, AddMovie::class.java)
            startActivity(addMovieIntent)
        }
        else if (item?.itemId == 1002) {
            val addMovieIntent = Intent(this, EditMovie::class.java)
            startActivity(addMovieIntent)
        }

        return super.onContextItemSelected(item)

    }
}
