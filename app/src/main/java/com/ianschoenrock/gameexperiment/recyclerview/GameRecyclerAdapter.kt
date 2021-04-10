package com.ianschoenrock.gameexperiment.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ianschoenrock.gameexperiment.R

class GameRecyclerAdapter: RecyclerView.Adapter<GameRecyclerAdapter.GameRecyclerViewHolder>() {

    val count = 10

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_game_background, parent, false)
        return GameRecyclerViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: GameRecyclerViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return count
    }

    inner class GameRecyclerViewHolder(view: View): RecyclerView.ViewHolder(view){
    }
}