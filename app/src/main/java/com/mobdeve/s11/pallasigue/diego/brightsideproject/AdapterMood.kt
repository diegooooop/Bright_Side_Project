package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class AdapterMood(private val data: ArrayList<MoodModel>): RecyclerView.Adapter<MoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_layout_new_entry, parent, false)

        val myViewHolder = MoodViewHolder(view)
        myViewHolder.itemView.setOnClickListener{
            val i = Intent(myViewHolder.itemView.context, Adjectives::class.java)
            i.putExtra("Name", data[myViewHolder.adapterPosition].name)
            i.putExtra("Adjectives", data[myViewHolder.adapterPosition].adjectives)
            myViewHolder.itemView.context.startActivity(i)
        }

        return myViewHolder
    }

    override fun onBindViewHolder(holder: MoodViewHolder, position: Int) {
        holder.bindData(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }
}