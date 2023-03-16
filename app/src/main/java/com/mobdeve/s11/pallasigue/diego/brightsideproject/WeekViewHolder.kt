package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WeekViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val mood: ImageView = itemView.findViewById(R.id.iv_mood)
    private val day: TextView = itemView.findViewById(R.id.tv_day)
    private val adjective: TextView = itemView.findViewById(R.id.tv_adjectives)
    private val notes: TextView = itemView.findViewById(R.id.tv_notes)

    fun bindData(data: WeeklyModel)
    {
        mood.setImageResource(data.imageId)
        day.text = data.day
        adjective.text = data.adjectives.toString()
        notes.text = data.notes
    }
}