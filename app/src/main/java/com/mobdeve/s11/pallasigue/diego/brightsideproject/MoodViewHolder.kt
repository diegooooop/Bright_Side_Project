package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.text.Layout
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MoodViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val moodBox: LinearLayout = itemView.findViewById(R.id.ll_moodBox)
    private val emoji: ImageView = itemView.findViewById(R.id.iv_emoji)
    private val name: TextView = itemView.findViewById(R.id.tv_name)

    fun bindData(data: MoodModel)
    {
        moodBox.setBackgroundColor(data.color)
        emoji.setImageResource(data.imageId)
        name.text = data.name
    }
}