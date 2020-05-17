package com.example.submission1

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.footballleageapps.ui.LeagueUI
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class LeagueAdapter(
    private val context: Context,
    private val leagues: List<League>,
    private val listener: (League) -> Unit
) : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LeagueUI().createView(AnkoContext.create(context, parent)))
    }

    override fun getItemCount(): Int = leagues.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(leagues[position], listener)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        var tvName: TextView = itemView.findViewById(LeagueUI.tvName)
        var ivImage: ImageView = itemView.findViewById(LeagueUI.ivImage)

        fun bind(leagues: League, listener: (League) -> Unit) {
            tvName.text = leagues.name
            leagues.image?.let { Glide.with(containerView).load(it).into(ivImage) }
            containerView.setOnClickListener { listener(leagues) }
        }
    }
}
