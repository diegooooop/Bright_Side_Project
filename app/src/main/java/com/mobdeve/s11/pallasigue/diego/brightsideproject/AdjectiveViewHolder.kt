package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.text.Layout
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.ColorUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AdjectiveViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val adjective: CheckBox = itemView.findViewById(R.id.btn_adjective)
    val background: LinearLayout = itemView.findViewById(R.id.rounded_layout)
    fun bindData(data: String , color: Int)
    {
        val lighterColor = ColorUtils.blendARGB(color, Color.WHITE, 0.9f)
        val gradientDrawable = GradientDrawable()

        adjective.text = data

        adjective.buttonTintList = ColorStateList.valueOf(color)

        gradientDrawable.shape = GradientDrawable.RECTANGLE
        gradientDrawable.cornerRadius = 20.dpToPx(itemView.context).toFloat()
        gradientDrawable.setColor(lighterColor)
        background.background = gradientDrawable

    }

    fun Int.dpToPx(context: Context): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            context.resources.displayMetrics
        ).toInt()
    }
}