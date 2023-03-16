package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.graphics.Color
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
    private val title: TextView = itemView.findViewById(R.id.tv_adjective_title)


    fun bindData(data: String , color: Int)
    {
        adjective.text = data
        adjective.setBackgroundColor(color)
        title.setTextColor(color)
    }
}