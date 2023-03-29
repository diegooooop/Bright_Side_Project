package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class WeekViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val date: TextView = itemView.findViewById(R.id.tv_logdate)
    private val bgcolor: LinearLayout = itemView.findViewById(R.id.ll_contententry)
    private val mood: ImageView = itemView.findViewById(R.id.iv_logmood)
    private val moodText: TextView = itemView.findViewById(R.id.tv_moodname)
    private val adjective: TextView = itemView.findViewById(R.id.tv_adjectivelist)
    private val notes: TextView = itemView.findViewById(R.id.tv_noteslist)



    @RequiresApi(Build.VERSION_CODES.O)
    fun bindData(data: EntryModel)
    {

        val current = data.date
        val formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
        val formatted = current.format(formatter)

        mood.setImageResource(data.model.imageId)
        moodText.text = data.model.name
        date.text = formatted.toString()
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