package com.example.submission1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission1.DetailsLeague.Companion.EXTRA_LEAGUE
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import com.example.submission1.DetailsLeague as DetailsLeague

class MainActivity : AppCompatActivity() {

    private var leagues: MutableList<League> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()

        verticalLayout {
            lparams(matchParent, wrapContent)
            backgroundColor = ContextCompat.getColor(context, android.R.color.holo_blue_light)
            recyclerView {
                layoutManager = LinearLayoutManager(context)
                adapter = LeagueAdapter(context, leagues) {
                    startActivity<DetailsLeague>(EXTRA_LEAGUE to it)
                }
            }
        }
    }

    private fun initData() {
        val leagueName = resources.getStringArray(R.array.league_name)
        val leagueId = resources.getStringArray(R.array.league_id)
        val leagueDesc = resources.getStringArray(R.array.league_description)
        val leagueImage = resources.obtainTypedArray(R.array.league_image)
        leagues.clear()
        for (i in leagueName.indices) {
            leagues.add(League(leagueName[i], leagueId[i], leagueDesc[i], leagueImage.getResourceId(i, 0)))
        }
        leagueImage.recycle()
    }
}
