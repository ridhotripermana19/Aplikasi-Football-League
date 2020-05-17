package com.example.submission1

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailsLeague : AppCompatActivity() {

    companion object {
        const val EXTRA_LEAGUE = "extra_league"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val league: League? = intent.getParcelableExtra(EXTRA_LEAGUE)

        scrollView {
            lparams(matchParent, matchParent)
            padding = dip(16)
            backgroundColor = ContextCompat.getColor(context, R.color.colorPrimary)

            linearLayout {
                lparams(matchParent, matchParent)
                orientation = LinearLayout.VERTICAL

                imageView {
                    Glide.with(this).load(league?.image).into(this)
                }.lparams {
                    height = dip(250)
                    width = dip(250)
                    gravity = Gravity.CENTER_HORIZONTAL
                    ImageView.ScaleType.FIT_XY
                }

                textView {
                    textSize = 22f
                    text = league?.name
                    textColor = Color.BLACK
                }.lparams {
                    gravity = Gravity.CENTER_HORIZONTAL
                    setMargins(0, dip(16), 0, dip(16))
                }

                textView {
                    textSize = 18f
                    text = context.getString(R.string.leagueId) + league?.id
                    textColor = Color.GRAY
                }.lparams {
                    gravity = Gravity.CENTER_HORIZONTAL
                    setMargins(0, 0, 0, dip(16))
                }

                textView {
                    textSize = 16f
                    text = league?.desc
                    textColor = Color.BLACK
                }.lparams {
                    textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                }
            }
        }
    }
}