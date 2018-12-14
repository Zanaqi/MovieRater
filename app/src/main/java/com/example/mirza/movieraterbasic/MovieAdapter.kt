package com.example.mirza.movieraterbasic

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.annotation.NonNull
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MovieAdapter : ArrayAdapter<MovieEntity> {

    var mContext: Context
    var moviesList = ArrayList<MovieEntity>()

    constructor(@NonNull context: Context, @LayoutRes list: ArrayList<MovieEntity>) :super(context, 0, list) {
        mContext = context
        moviesList = list
    }

    @NonNull
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false)

        val currentMovie = getItem(position) as MovieEntity

        val image = listItem.findViewById<ImageView>(R.id.imageView_poster)
        image.setImageResource(currentMovie.mImageDrawable)

        val name = listItem.findViewById<TextView>(R.id.textView_name)
        name.setText(currentMovie.title)

        return listItem
    }
}