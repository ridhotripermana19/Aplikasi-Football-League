package com.example.footballleageapps.ui

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class LeagueUI : AnkoComponent<ViewGroup> {

    companion object {
        const val tvName = 1
        const val ivImage = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {

        verticalLayout {
            this.orientation = LinearLayout.HORIZONTAL
            lparams(matchParent, wrapContent)
            padding = dip(16)

            imageView {
                id = ivImage
            }.lparams {
                height = dip(70)
                width = dip(70)
                gravity = Gravity.CENTER
            }

            textView {
                id = tvName
                textSize = 16f
                textColor = Color.BLACK
            }.lparams {
                gravity = Gravity.CENTER
                margin = dip(10)
            }
        }
    }
}