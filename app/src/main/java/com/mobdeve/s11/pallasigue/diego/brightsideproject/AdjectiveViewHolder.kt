package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AdjectiveViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val adjective: Button = itemView.findViewById(R.id.btn_adjective)

    var i = 0;
    fun bindData(data: MoodModel)
    {
        adjective.text = data.adjectives[i]
        i += 1
    }
}