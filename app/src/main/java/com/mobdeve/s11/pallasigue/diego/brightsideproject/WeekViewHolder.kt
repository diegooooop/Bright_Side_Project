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
    private val bgcolor: LinearLayout = itemView.findViewById(R.id.ll_content)

    fun bindData(data: EntryModel)
    {
        mood.setImageResource(data.model.imageId)
        moodText.text = data.model.name
        day.text = data.day
  //      adjective.text = data.model.adjectives.toString()
        notes.text = data.notes
        bgcolor.setBackgroundColor(data.model.color)

        var i = data.model.adjectives.size-1

        var text = " "

        for(g in 0..i)
        {
            text += data.model.adjectives[g]

            if(i != g)
                text += " , "
        }
        adjective.text = text
    }
}