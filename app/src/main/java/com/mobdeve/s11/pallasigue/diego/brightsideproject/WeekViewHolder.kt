package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class WeekViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val mood: ImageView = itemView.findViewById(R.id.iv_mood)
    private val day: TextView = itemView.findViewById(R.id.tv_day)
    private val adjective: TextView = itemView.findViewById(R.id.tv_adjectives)
    private val notes: TextView = itemView.findViewById(R.id.tv_notes)
    private val moodText: TextView = itemView.findViewById(R.id.tv_moodText)
    private val bgcolor: LinearLayout = itemView.findViewById(R.id.ll_daysummary)

    fun bindData(data: EntryModel)
    {
        mood.setImageResource(data.model.imageId)
        moodText.text = "You are" + data.model.name
        day.text = data.day
        adjective.text= data.model.adjectives.toString()
        notes.text = data.notes
        bgcolor.setBackgroundColor(data.model.color)
    }
}