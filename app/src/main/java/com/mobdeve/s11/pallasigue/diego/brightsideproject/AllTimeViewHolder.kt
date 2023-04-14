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

class AllTimeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
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

        gradientDrawable.shape = GradientDrawable.RECTANGLE
        gradientDrawable.cornerRadius = 10.dpToPx(itemView.context).toFloat()
        gradientDrawable.setStroke(5.dpToPx(itemView.context), data.model.color)
        bgcolor.background = gradientDrawable


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