package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/* this adapter is for setting up the moods for adapter  */
class AdapterMood(private val data: ArrayList<MoodModel>): RecyclerView.Adapter<MoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_layout_new_entry, parent, false)

        val myViewHolder = MoodViewHolder(view)
        myViewHolder.itemView.setOnClickListener{
            /* creates an intent to send the mood model contents to send onclick */
            val i = Intent(myViewHolder.itemView.context, Adjectives::class.java)
            i.putExtra("Name", data[myViewHolder.adapterPosition].name)
            i.putExtra("ImageId", data[myViewHolder.adapterPosition].imageId)
            i.putExtra("Adjectives", data[myViewHolder.adapterPosition].adjectives)
            i.putExtra("Color", data[myViewHolder.adapterPosition].color)
            myViewHolder.itemView.context.startActivity(i)
            (myViewHolder.itemView.context as Activity).finish()
        }

        return myViewHolder
    }
    /* standard onBindViewHolder */
    override fun onBindViewHolder(holder: MoodViewHolder, position: Int) {
        holder.bindData(data[position])
    }
    /* standard function for returning item size */
    override fun getItemCount(): Int {
        return data.size
    }
}