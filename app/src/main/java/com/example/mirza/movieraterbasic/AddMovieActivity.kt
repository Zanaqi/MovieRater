package com.example.mirza.movieraterbasic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.add_movie.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_movie)

        suitChk1.setOnClickListener(View.OnClickListener{

            if (suitChk1.isChecked == true) {

                suitChk2.setVisibility(View.VISIBLE)
                suitChk3.setVisibility(View.VISIBLE)

            } else {

                suitChk2.setVisibility(View.GONE)
                suitChk3.setVisibility(View.GONE)
            }
        })
    }

    fun btnValidate(v: View) {

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

        if (validation) {

            val languageId = findViewById<RadioButton>(language.checkedRadioButtonId)

            var toastText: String

            val titleText = "Title = " + movie_title.text + "\n"
            val descText = "Overview = " + description.text + "\n"
            val releaseDateText = "Release Date = " + releaseDate.text + "\n"
            val languageText = "Language = " + languageId.text + "\n"
            val suitabilityText = "Suitable for all ages = " + suitChk1.isChecked + "\n"

            toastText = titleText + descText + releaseDateText + languageText + suitabilityText

            if (suitChk1.isChecked) {

                var reasonText = "Reason\n"

                if (suitChk2.isChecked) {

                    reasonText += suitChk2.text
                    reasonText += "\n"

                    if (suitChk3.isChecked) {

                        reasonText += suitChk3.text
                    }
                }

                toastText += reasonText

            }

            Toast.makeText(
                this,
                toastText,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
