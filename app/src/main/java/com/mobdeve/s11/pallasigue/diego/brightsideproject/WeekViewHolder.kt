package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.graphics.ColorUtils
import androidx.recyclerview.widget.RecyclerView
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class WeekViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val date: TextView = itemView.findViewById(R.id.tv_logdate)
    private val day: TextView = itemView.findViewById(R.id.tv_logday)
    private val bgcolor: LinearLayout = itemView.findViewById(R.id.ll_contententry)
    private val mood: ImageView = itemView.findViewById(R.id.iv_logmood)
    private val moodText: TextView = itemView.findViewById(R.id.tv_moodname)
    private val adjectiveTitle: TextView = itemView.findViewById(R.id.adjectives)
    private val adjective: TextView = itemView.findViewById(R.id.tv_adjectivelist)
    private val notesTitle: TextView = itemView.findViewById(R.id.notes)
    private val notes: TextView = itemView.findViewById(R.id.tv_noteslist)



    @RequiresApi(Build.VERSION_CODES.O)
    fun bindData(data: EntryModel)
    {

        val currentDate = data.date
        val formatterDate = DateTimeFormatter.ofPattern("MMMM d, yyyy")
        val formattedDate = currentDate.format(formatterDate)

        val currentDay = data.date
        val formatterDay = DateTimeFormatter.ofPattern("EEEE")
        val dayOfWeekDay = currentDay.format(formatterDay)

        val lighterColor = ColorUtils.blendARGB(data.model.color, Color.WHITE, 0.55f)
        val gradientDrawable = GradientDrawable()

        mood.setImageResource(data.model.imageId)
        moodText.text = data.model.name
        moodText.setTextColor(data.model.color)
        date.text = formattedDate
        day.text = dayOfWeekDay

        day.setTextColor(data.model.color)

        adjectiveTitle.setBackgroundColor(lighterColor)
        notesTitle.setBackgroundColor(lighterColor);

        gradientDrawable.shape = GradientDrawable.RECTANGLE
        gradientDrawable.cornerRadius = 10.dpToPx(itemView.context).toFloat()
        gradientDrawable.setStroke(5.dpToPx(itemView.context), data.model.color)
        bgcolor.background = gradientDrawable



  //      adjective.text = data.model.adjectives.toString()
        notes.text = data.notes
//        bgcolor.setBackgroundColor(data.model.color)

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

    fun Int.dpToPx(context: Context): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            context.resources.displayMetrics
        ).toInt()
    }
}
