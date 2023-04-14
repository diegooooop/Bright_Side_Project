package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.text.Layout
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.graphics.ColorUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
/* the moodview holder is the viewholder that populates the layout for moods in mainactivity */
class MoodViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val moodBox: LinearLayout = itemView.findViewById(R.id.ll_moodBox)
    private val emoji: ImageView = itemView.findViewById(R.id.iv_emoji)
    private val name: TextView = itemView.findViewById(R.id.tv_name)

    fun bindData(data: MoodModel)
    {
        val lighterColor = ColorUtils.blendARGB(data.color, Color.WHITE, 0.8f)
        val gradientDrawable = GradientDrawable()

        /* this code configures the color for the background of the linear layout for the mood */
        gradientDrawable.shape = GradientDrawable.RECTANGLE
        gradientDrawable.cornerRadius = 10.dpToPx(itemView.context).toFloat()
        gradientDrawable.setStroke(2.dpToPx(itemView.context), data.color)
        gradientDrawable.setColor(lighterColor)
        moodBox.background = gradientDrawable

        emoji.setImageResource(data.imageId)
        name.setTextColor(data.color)
        name.text = data.name
    }

    /* function to change dp to px*/
    fun Int.dpToPx(context: Context): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            context.resources.displayMetrics
        ).toInt()
    }
}