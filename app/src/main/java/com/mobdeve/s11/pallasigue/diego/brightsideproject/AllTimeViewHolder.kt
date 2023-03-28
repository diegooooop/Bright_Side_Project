package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.nfc.Tag
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class AllTimeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
    private val mood: ImageView = itemView.findViewById(R.id.iv_mood)
    private val day: TextView = itemView.findViewById(R.id.tv_day)
    private val date: TextView = itemView.findViewById(R.id.tv_date)
    private val adjective: TextView = itemView.findViewById(R.id.tv_adjectives)
    private val notes: TextView = itemView.findViewById(R.id.tv_notes)
    private val moodText: TextView = itemView.findViewById(R.id.tv_moodText)
    private val bgcolor: LinearLayout = itemView.findViewById(R.id.ll_daysummary)

    @RequiresApi(Build.VERSION_CODES.O)
    fun bindData(data: EntryModel)
    {

        val current = data.date
        val formatter = DateTimeFormatter.BASIC_ISO_DATE
        val formatted = current.format(formatter)
        Log.d("Tag", formatted.toString())

        mood.setImageResource(data.model.imageId)
        moodText.text = data.model.name
        day.text = formatted.toString()
        date.text = data.day
        adjective.text = data.model.adjectives.toString()
        notes.text = data.notes
        bgcolor.setBackgroundColor(data.model.color)
    }
}